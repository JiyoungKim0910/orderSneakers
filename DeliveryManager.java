package mission.orderSneakers;

import java.awt.desktop.SystemSleepEvent;

public class DeliveryManager {
    private long deliveryFee;
    private int deliveryPeriod;
    private long salesAmount;
    private SneakersInfo sneakersInfo;

    public DeliveryManager(long deliveryFee, int deliveryPeriod, SneakersInfo sneakersInfo) {
        this.salesAmount = 100_000;
        this.deliveryFee = deliveryFee;
        this.deliveryPeriod = deliveryPeriod;
        this.sneakersInfo = sneakersInfo;
    }
    public long getDeliveryFee() {
        return deliveryFee;
    }
    public int getDeliveryPeriod() {
        return deliveryPeriod;
    }
    public void setDeliveryPeriod(int deliveryPeriod) {
        this.deliveryPeriod = deliveryPeriod;
    }
    public void setDeliveryFee(long deliveryFee) {
        this.deliveryFee = deliveryFee;
    }
    public Sneakers setSneakersPackage(SneakersInfo sneakersInfo) {
        return new Sneakers(sneakersInfo);
    }
    public long deliverySneakersToCustomer() {
        System.out.printf("배송 담당자: 고객님, 주문하신 운동화 배송드립니다. 배송료는 %d 입니다. \n" ,this.deliveryFee );
        return this.deliveryFee;
    }
    public void addSalesAmount(long fee) {
        this.salesAmount += fee;
        System.out.printf("결제 완료되었습니다. 감사합니다~~");
    }
}
