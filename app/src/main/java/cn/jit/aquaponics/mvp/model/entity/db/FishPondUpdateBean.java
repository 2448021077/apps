package cn.jit.aquaponics.mvp.model.entity.db;

public class FishPondUpdateBean {
    /**
     * 标示 对应生产单元的条目的ID
     */
    private int itemPosition;
    /**
     * 条目的具体数据
     */
    private FishPondBean mFishPondResponse;

    public int getItemPosition() {
        return itemPosition;
    }

    public void setItemPosition(int itemPosition) {
        this.itemPosition = itemPosition;
    }

    public FishPondBean getFishPondResponse() {
        return mFishPondResponse;
    }

    public void setFishPondResponse(FishPondBean fishPondResponse) {
        mFishPondResponse = fishPondResponse;
    }
}
