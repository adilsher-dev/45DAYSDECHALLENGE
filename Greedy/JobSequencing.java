package Greedy;
import java.util.*;

class Job {
    int id , deadline , profit;

    Job(int id,int deadline,int profit){
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencing {

    static int[] Calc(Job [] jobs){

        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);//use of comparator

        int maxDeadline = 0;

        for(Job job : jobs){
            maxDeadline = Math.max(maxDeadline,job.deadline);
        }

        int [] slots = new int[maxDeadline+1];
        Arrays.fill(slots,-1);

        int maxJob = 0;
        int maxProfit = 0;

        for(Job job : jobs){

            for(int j = job.deadline; j >= 0;j--){
                if(slots[j]  == -1){
                    slots[j] = job.id;
                    maxJob += 1;
                    maxProfit += job.profit;
                    break;
                }
            }
        }
        return new int [] {maxJob,maxProfit};

    }
    public static void main(String[] args){

        Job [] jobs = {new Job(1,4,20),
            new Job(2,1,10),
            new Job(3,1,40),
            new Job(4,1,30)
        };

        int [] ans = Calc(jobs);

        System.out.println("The Total jobs"+ans[0]);
        System.out.println("The Total Profit"+ans[1]);
    }
}
