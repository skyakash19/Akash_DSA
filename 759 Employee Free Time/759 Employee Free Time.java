import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);

        for (List<Interval> intervals : schedule) {
            pq.addAll(intervals);
        }

        Interval prev = pq.poll();
        while (!pq.isEmpty()) {
            Interval curr = pq.poll();
            if (prev.end < curr.start) {

                result.add(new Interval(prev.end, curr.start));
                prev = curr;
            } else {

                prev.end = Math.max(prev.end, curr.end);
            }
        }

        return result;
    }

    
}
