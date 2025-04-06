package user;

public class UserSingleton
{
    private static UserSingleton instance;

    private String username;
    private int lastDraws;
    private int lastLimitedDraws;
    private boolean missedPickUp;
    private Backpack backpack;

    // 私有构造函数，确保外部无法直接实例化
    private UserSingleton(String username) {
        this.username = username;
        this.lastDraws = 0;
        this.lastLimitedDraws = 0;
        this.missedPickUp = false;
        this.backpack = new Backpack(); // 初始化背包
    }

    // 获取全局唯一实例
    public static synchronized UserSingleton getInstance(String username) {
        if (instance == null) {
            instance = new UserSingleton(username);
        }
        return instance;
    }

    public static synchronized UserSingleton getInstance() {
        if (instance == null) {
            throw new IllegalStateException("User not initialized. Call getInstance(String username) first.");
        }
        return instance;
    }

    // 清除单例实例（用于切换用户）
    public static synchronized void clearInstance() {
        instance = null;
    }

    public String getUsername() {
        return username;
    }

    public Backpack getBackpack() {
        return backpack;
    }

    public int getLastDraws(boolean limited)
    {
        return limited ? lastLimitedDraws : lastDraws;
    }

    public void setLastDraws(boolean limited, int drawCount)
    {
        if (limited)
            lastLimitedDraws = drawCount;
        else
            lastDraws = drawCount;
    }

    public boolean isMissedPickUp()
    {
        return missedPickUp;
    }

    public void setMissedPickUp(boolean missedPickUp)
    {
        this.missedPickUp = missedPickUp;
    }
}

