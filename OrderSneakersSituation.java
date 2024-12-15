package mission.orderSneakers;

public class OrderSneakersSituation {
    public static void main(String[] args) {
        // 변수 변경 가능
        // Customer 의 잔액, DeliveryManager 매상, Staff 매상은 모두 10만원 시작 입니다.

        boolean isCustomerLikeDelivery = true; // 고객의 배송 주문 선호 여부

        String nikeSneakersFeature = "안정감"; // 안정감 | 편안함 | 가벼움 등 신발 특징
        long nikeSneakersPrice = 50_000;
        boolean havingNikeSneakersInStore = false; // 매장 Nike sneakers 재고 여부

        int daysForDeliver = 3;
        int costForDeliver = 15_000;

        /*
         *  필수 인스턴스 생성
         *  Customer, staff, DeliveryManager를 생성하고 시작합니다.
         *  각각 Customer, Staff, DeliveryManager 는 정보 은닉화 를 따르기 때문에 한정된 정보를 가지게 됩니다.
         *
         *  Customer: 자신의 Cache 와 배송 주문선호 여부
         *  Staff: 자신의 매상, Nike 운동화 정보, 매장의 Nike 운동화 재고 보유여부
         *  DeliverManager: 자신의 매상, Nike 운동화 정보, 포장 정보
         * */

        // TODO: 클래스를 선언하고, 객체간의 협력으로 구현해주세요.
        Customer customer = new Customer();
        customer.setLikeDelivery(isCustomerLikeDelivery);

        Staff staff = new Staff();
        staff.setSalesAmount(100_000);

        SneakersInfo sneakersInfo = new SneakersInfo(nikeSneakersPrice,nikeSneakersFeature);
        sneakersInfo.setSneakersInStock(havingNikeSneakersInStore);


        // 매장직원에게 신발 정보 요청
        customer.askSneakersInfo(staff);
        long sneakersPrice = staff.answerSneakersInfo(sneakersInfo);

        if ( !customer.availableOrder(sneakersPrice) ) {
            customer.sayBye();
            return;
        }
        // 운동화 재고가 있는 경우
        if ( staff.cheakHavingSneakersInStore(sneakersInfo) ){
            customer.sayOrder();
            long price = staff.requestPayment(sneakersInfo);
            customer.paySneakers(price);
            staff.addSalesAmount(price);

            Sneakers newSneakers = staff.offerSneakers(sneakersInfo);
            customer.putOnSneakers(newSneakers);
        }
        // 매장 재고가 없는 경우
        else {
            staff.checkDelivery();
            if (!customer.isLikeDelivery()) {
                //배송X
                customer.sayBye();
            } else {
                customer.sayOrder();
                long price = staff.requestPayment(sneakersInfo);
                customer.paySneakers(price);
                staff.addSalesAmount(price);
                DeliveryManager deliveryManager = new DeliveryManager(costForDeliver, daysForDeliver, sneakersInfo);
                long deliveryFee = staff.checkDeliveryInfo(deliveryManager);

                if (!customer.availableOrder(deliveryFee)) {
                    customer.requestRefund();
                    staff.refundSneakers(price);
                    customer.getRefund(price);
                    customer.sayBye();
                } else {
                    customer.sayOrder();
                    Sneakers newSneakers = deliveryManager.setSneakersPackage(sneakersInfo);
                    long shippingFee = deliveryManager.deliverySneakersToCustomer();
                    customer.paySneakers(shippingFee);
                    deliveryManager.addSalesAmount(shippingFee);
                    customer.putOnSneakers(newSneakers);
                }
            }
        }
    }

}
