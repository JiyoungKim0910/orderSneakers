package mission.orderSneakers;

public class SneakersInfo {
    private String sneakersFeature;
    private long sneakersPrice;
    private boolean sneakersinStock;

    public SneakersInfo(long sneakersPrice,String sneakersFeature) {
        this.sneakersFeature = sneakersFeature;
        this.sneakersPrice = sneakersPrice;
    }

    public String getSneakersFeature() {
        return sneakersFeature;
    }

    public long getSneakersPrice() {
        return sneakersPrice;
    }

    public boolean getSneakersInStock() {
        return sneakersinStock;
    }

    public void setSneakersInStock(boolean sneakersinStock) {
        this.sneakersinStock = sneakersinStock;
    }

}
