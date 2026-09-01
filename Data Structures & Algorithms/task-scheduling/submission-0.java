class Solution {
    public class Tasks {
        int freq;
        char c;
        public Tasks(int n, char c){
            this.freq = n;
            this.c = c;
        }
    }
    public class CPUTask {
        int nextAvailable;
        Tasks c;
        public CPUTask(int n, Tasks c){
            this.nextAvailable = n;
            this.c = c;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Tasks> pq = new PriorityQueue<Tasks>((a,b)->(b.freq-a.freq));
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c:tasks){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(char c: map.keySet()){
            pq.add(new Tasks(map.get(c),c));
        }

        Queue<CPUTask> q  = new LinkedList<>();
        int time = 0;
        while(!pq.isEmpty() || !q.isEmpty()){
            time++;
            if(!pq.isEmpty()){
                Tasks toBeProcessed = pq.remove();
                toBeProcessed.freq--;
                if(toBeProcessed.freq>0){
                q.add(new CPUTask(time+n,toBeProcessed));
                }
            }
            while(!q.isEmpty() && q.peek().nextAvailable<=time){
                pq.add(q.remove().c);
            }
        }
        return time;

        
    }
}
