package Managers;

public class SingletonAppManager {

    private static SingletonAppManager singletonAppManager= null;
    public AppManager manager;

    private SingletonAppManager(){
        manager = new AppManager(){};
    }

    public static SingletonAppManager getInstance(){
        if (singletonAppManager == null){
            singletonAppManager = new SingletonAppManager();
        }
        return singletonAppManager;
    }
}
