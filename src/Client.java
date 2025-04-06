import facade.Facade;

public class Client
{

    public static void main(String[] args) throws InterruptedException
    {
        Facade facade;

        opening();

        facade = new Facade("ruanzh");

        while(true)
        {
            System.out.println("================");
            System.out.println("\t 主菜单");
            System.out.println("\t1. 召唤");
            System.out.println("\t2. 背包");
            System.out.println("\t3. 退出");
            System.out.println("================");

            int menuChoice = getUserInput(1, 3);
            switch (menuChoice)
            {
                case 1:
                    gachaMenu(facade);
                    break;
                case 2:
                    backpackMenu(facade);
                    break;
                case 3:
                    return;
            }
        }
    }

    private static void backpackMenu(Facade facade)
    {
        while (true)
        {
            System.out.println("================");
            System.out.println("\t菜单 - 背包:");
            System.out.println("\t1. 查看角色卡");
            System.out.println("\t2. 查看武器卡");
            System.out.println("\t3. 返回");
            System.out.println("================");

            int actionChoice = getUserInput(1, 3);
            switch (actionChoice)
            {
                case 1:
                    facade.displayCharacterCards();
                    break;
                case 2:
                    facade.displayWeaponCards();
                    break;
                case 3:
                    return;
            }
        }
    }

    private static void gachaMenu(Facade facade)
    {
        System.out.println("================");
        System.out.println("\t菜单 - 卡池选择:");
        System.out.println("\t1. 活动召唤 - 1");
        System.out.println("\t2. 活动召唤 - 2");
        System.out.println("\t3. 角色召唤");
        System.out.println("\t4. 武器召唤");
        System.out.println("\t5. 返回");
        System.out.println("================");

        int poolChoice = getUserInput(1, 5);
        if (poolChoice == 5) return;

        facade.registerGacha(poolChoice);

        while (true)
        {
            System.out.println("================");
            System.out.println("\t菜单 - 召唤操作:");
            System.out.println("\t1. 单抽");
            System.out.println("\t2. 10连");
            System.out.println("\t3. 概率");
            System.out.println("\t4. 返回");
            System.out.println();
            facade.getDrawCountLeft();
            System.out.println("================");

            int actionChoice = getUserInput(1, 4);
            switch (actionChoice)
            {
                case 1:
                    facade.singleDraw();
                    break;
                case 2:
                    facade.tenDraw();
                    break;
                case 3:
                    facade.getDetail();
                    break;
                case 4:
                    return;
            }
        }
    }

    // 模拟用户输入
    private static int getUserInput(int min, int max)
    {
        System.out.println();
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int choice;
        do
        {
            System.out.print("请输入 (" + min + "-" + max + "): ");
            while (!scanner.hasNextInt())
            {
                System.out.println("非法输入，请重试！");
                scanner.next();
            }
            choice = scanner.nextInt();
        } while (choice < min || choice > max);
        System.out.println();
        return choice;
    }

    private static void opening() throws InterruptedException
    {
        System.out.println();
        System.out.println("\033[37mMade by\033[36m LEV ZH.RUAN\033[0m");
        System.out.println();
        System.out.println("Loading......");
        Thread.sleep(5000);
        System.out.println();
        System.out.println("\033[33m-~-MINO-SUPER-LEAGUE-~-\033[0m");
        System.out.println("\033[37mv0.01 java console demo\033[0m");
        System.out.println();
    }
}