import java.util.*;
public class ActivitySelection {
    static class Activity {
        int start;
        int finish;
        Activity(int start,int finish) {
            this.start=start;
            this.finish=finish;
        }
    }
    public static void main(String[] args) {
        Activity[] activities = {
                new Activity(1,2),
                new Activity(3,4),
                new Activity(0,6),
                new Activity(5,7),
                new Activity(8,9),
                new Activity(5,9),
        };
        Arrays.sort(activities,Comparator.comparingInt(a->a.finish));
        int lastFinish = -1;
        int count = 0;
        System.out.println("Selected Activities:");
        for(Activity a:activities) {
            if(a.start>=lastFinish) {
                System.out.println(a.start+"->"+a.finish);
                lastFinish=a.finish;
                count++;
            }
        }
        System.out.println("Maximum Activties = "+count);
    }
}