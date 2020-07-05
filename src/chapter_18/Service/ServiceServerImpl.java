package chapter_18.Service;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class ServiceServerImpl extends UnicastRemoteObject implements  ServiceServer {
    HashMap serviceList;

    protected ServiceServerImpl() throws RemoteException {
        setUpService();
    }
    private void setUpService(){
        serviceList = new HashMap();
        serviceList.put("Dice Rolling Service", new DiceService());
        serviceList.put("Day of week Service", new DayOfWeekService());
        serviceList.put("Visual Music Service", new MiniMusicService());
    }

    @Override
    public Object[] getServiceList() throws RemoteException {
        System.out.println("in remote");
        return serviceList.keySet().toArray();
    }

    @Override
    public Service getService(Object serviceKey) throws RemoteException {
        Service theService = (Service) serviceList.get(serviceKey);
        return theService;
//        return null;
    }

    public static void main(String[] args) {
        try{
            Naming.rebind("ServiceServer", new ServiceServerImpl());
        }catch (Exception ex){ex.printStackTrace();}
        System.out.println("Remote service is running");
    }

}
