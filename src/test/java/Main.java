import utils.Service;

/**
 * Created by kyak on 19.10.2015.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(Service.nowTime());
        System.out.println(Service.nowTimeForFileName());
        System.out.println(Service.nowTimeForObjectName());
        System.out.println(Service.nowTimeForOrgName());
        System.out.println(Service.hourForOrg());
    }
}
