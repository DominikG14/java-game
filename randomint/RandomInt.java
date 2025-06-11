package randomint;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class RandomInt {
    private Random random = new Random();

    public static int WeightedRandomInt(List<int> nums, List<int> prob){
        if (nums == null || prob == null || nums.Count == 0 || prob.Count == 0 || nums.Count != prob.Count){
            throw new ArgumentException("Input lists must be non-empty.");
        }
        
        if(nums.Count != prob.Count){
            throw new ArgumentException("and of the same length");
        }

        List<int> calcProb = new ArrayList<int>();
        int currProb;

        for(int i = 0; i < nums.size(); i++){
            
        }

        int perc = random.nextInt(100);
    }
}
