package mission.orderSneakers;

public class Customer {
    private long myCash;
    private boolean likeDelivery;
    private String myFeeling;

    public Customer(){
        this.myCash = 100_000;
        this.myFeeling = "보통";
    }

    public void setMyCash(long myCash) {
        this.myCash = myCash;
    }

    public void setLikeDelivery(boolean likeDelivery) {
        this.likeDelivery = likeDelivery;
    }

    public boolean isLikeDelivery() {
        return likeDelivery;
    }

    // 행위
    public void askSneakersInfo(Staff staff) {
        System.out.println("고객: Nike 운동화에 대해 알려주세요.");
    }

    public boolean availableOrder(long productPrice){
        return this.myCash >= productPrice;
    }
    public void sayBye(){
        System.out.printf("고객: 다음에 올게요~~ 제 기분은 %s이고, 보유금액은 %d 입니다. \n", this.myFeeling, this.myCash);
    }
    public void sayOrder(){
        System.out.println("고객: 네, 주문하겠습니다.");
    }
    public void paySneakers(long productPrice){
        this.myCash -= productPrice;
        System.out.println("고객: 결제해주세요~");
    }
    public void putOnSneakers(Sneakers sneakers){
        this.myFeeling="좋음";
        System.out.printf("고객: 이 신발은 %s이 좋네요, 기분이 %s 입니다. 현재 잔고는 %d 입니다.\n",sneakers.getSneakersInfo().getSneakersFeature(), this.myFeeling,this.myCash);
    }

    public void requestRefund(){
        System.out.println("고객: 배송료가 비싸네요, 환불 부탁드립니다.");

    }
    public void getRefund(long productPrice){
        this.myCash += productPrice;
        System.out.println("고객: 확인했습니다. 감사합니다.");
    }
}
