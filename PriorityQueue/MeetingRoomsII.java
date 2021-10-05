import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// Link: https://leetcode.com/problems/meeting-rooms-ii/
// Difficulty: Medium
// Time complexity: O(nlogn)
// Space complexity: O(n)

class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        
        // initializing Min Heap which will be sorted by end time of meetings
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(intervals.length, 
        new Comparator<Integer>() {
            public int compare (Integer a, Integer b) {
                return a - b;
            }
        });
        
        // sorting intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        // adding first meeting
        pq.add(intervals[0][1]);
        
        
        // starting at 1 because the first interval was alr added to the queue
        for (int i = 1; i < intervals.length; i++) {
            
            // if the room that will free up the earliest is currently free, we will assign the interval/meeting time to that room
            if (intervals[i][0] >= pq.peek()) {
                pq.poll();
            }
            
            // must add meeting time to heap since there is no room available right now
            pq.add(intervals[i][1]);
            
        }
        return pq.size();
    }
}
