package mission.orderSneakers;

public class Staff {
    private long salesAmount;

    public void setSalesAmount(long salesAmount) {
        this.salesAmount = salesAmount;
    }


    //행위
    public long answerSneakersInfo(SneakersInfo sneakersInfo) {
        System.out.printf("매장직원: 손님, 이 운동화는 %s이 느껴지며 , 가격은 %d 입니다.\n",sneakersInfo.getSneakersFeature(),sneakersInfo.getSneakersPrice());
        return sneakersInfo.getSneakersPrice();
    }
    public boolean cheakHavingSneakersInStore(SneakersInfo sneakersInfo) {
        return sneakersInfo.getSneakersInStock();
    }
    public long requestPayment(SneakersInfo sneakersInfo) {
        long price = sneakersInfo.getSneakersPrice();
        System.out.printf("매장직원: 손님, 결제금액은 %d 입니다.\n",price);
        return price;
    }
    public void addSalesAmount(long salesAmount) {
        this.salesAmount += salesAmount;
        System.out.println("매장직원: 손님, 결제되었습니다.");
    }
    public Sneakers offerSneakers(SneakersInfo sneakersInfo) {
        System.out.println("매장직원: 여기 새상품입니다.");
        return new Sneakers(sneakersInfo);
    }
    public void checkDelivery(){
        System.out.println("매장직원: 현재 매장에 재고가 없습니다. 배송으로 받으시겠습니까?");
    }
    public long checkDeliveryInfo(DeliveryManager deliveryManager) {
        System.out.printf("매장직원: 배송 예정 소요일자는 %d일이고, 배송료는 %d입니다. \n",deliveryManager.getDeliveryPeriod(),deliveryManager.getDeliveryFee());
        return deliveryManager.getDeliveryFee();
    }
    public void refundSneakers(long refundCash) {
        this.salesAmount -= refundCash;
        System.out.println("매장직원: 환불이 완료되었습니다. 확인해주세요");
    }
}
