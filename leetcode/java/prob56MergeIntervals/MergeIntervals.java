/*
Problem 56: Merge Intervals

Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
*/

import java.util.*;

public class MergeIntervals {

  public static class Interval {
    public int start, end;

    public Interval() {
      start = 0;
      end = 0;
    }
    public Interval(int s, int e) {
      start = s;
      end = e;
    }
  }

  public List<Interval> merge(List<Interval> intervals) {

    List<Interval> result = new ArrayList<>();
    if (intervals == null || intervals.size() == 0) return result;

    // Using java 8 lambda, we sort intervals with increasing order of starting of interval
    intervals.sort( (i1, i2) -> Integer.compare(i1.start, i2.start) );

    int n = intervals.size();

    // Get start and end of first interval
    Interval firstInterval = intervals.get(0);
    int previousStart = firstInterval.start, previousEnd = firstInterval.end;

    for (int i = 1; i < n; i++) {
     Interval currentInterval = intervals.get(i);
     // if current interval starts before the end of the prevous one, then there is overlapping.
     if (currentInterval.start <= previousEnd) {
        previousEnd = Math.max(currentInterval.end, previousEnd); // update end to be the largest of the 2 ends
     } else { // no overlapping, so we add to result an interval that starts at previousStart and ends at previousEnd
       result.add(new Interval(previousStart, previousEnd));
       // we then update previousStart and previousEnd to that of currentInterval
       previousStart = currentInterval.start;
       previousEnd = currentInterval.end;
     }
    }
    // we add the last interval to result
    result.add(new Interval(previousStart, previousEnd));

    return result;
  }
}
