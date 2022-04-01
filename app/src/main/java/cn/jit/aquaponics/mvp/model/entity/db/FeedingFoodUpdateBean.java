package cn.jit.aquaponics.mvp.model.entity.db;

public class FeedingFoodUpdateBean {

    private int itemPosition;

    private FeedingFoodBean feedingFoodResponse;

    public int getItemPosition() {
        return itemPosition;
    }

    public void setItemPosition(int itemPosition) {
        this.itemPosition = itemPosition;
    }

    public FeedingFoodBean getFeedingFoodResponse() {
        return feedingFoodResponse;
    }

    public void setFeedingFoodResponse(FeedingFoodBean feedingFoodResponse) {
        this.feedingFoodResponse = feedingFoodResponse;
    }
}
