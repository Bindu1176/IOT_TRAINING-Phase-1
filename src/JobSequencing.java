import java.util.*;
public class JobSequencing {
    static class Job {
        char id;
        int deadline;
        int profit;
        Job(char id,int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }
    public static void main(String[] args) {
        Job[] jobs = {
                new Job('A',2,100),
                new Job('B',1,19),
                new Job('C',2,27),
                new Job('D',1,25),
                new Job('E',3,15)
        };
        Arrays.sort(jobs,(a,b)->b.profit-a.profit);
        int maxDeadline = 0;
        for(Job job : jobs) {
            maxDeadline = Math.max(maxDeadline,job.deadline);
        }
        char[] schedule = new char[maxDeadline+1];
        boolean[] occupied = new boolean[maxDeadline+1];
        int totalProfit = 0;
        for(Job job : jobs) {
            for(int slot = job.deadline;slot>=1;slot--) {
                if(!occupied[slot]) {
                    occupied[slot]=true;
                    schedule[slot]=job.id;
                    totalProfit+=job.profit;
                    break;
                }
            }
        }
        System.out.println("Job Schedule:");
        for(int i=1;i<schedule.length;i++) {
            System.out.println("Slot "+i+" -> Job "+schedule[i]);
        }
        System.out.println("Maximum Profit = "+totalProfit);
    }
}