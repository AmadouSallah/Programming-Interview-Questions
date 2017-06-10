/*
Problem 252: 252. Meeting Rooms

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
determine if a person could attend all meetings.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return false.
*/

/*
PSEUDOCODE

There is an overlap if there is an interval (meeting) whose begining time is < the ending of another meeting (interval).
So in order to avoid overlap, the next meeting's start time should be later the previous meeting's end time
Example, meeting1 = [5, 15] and meeting2 = [10, 20]. Since 5 < 20, these 2 meetings overlap

We initiate 2 arrays startingTimes and endingTimes; startingTimes will contain the beginings of all the meetings
whereas endingTimes will contain the ending of meetings.
We then sort these 2 arrays.

We iterate over startingTimes, starting at index i=1.
    if we find an element in startingTimes that is smaller than the element at index i-1 of endingTimes , we return false
    since that means we have found a meeting whose starting time is before the ending time of the previous meeting.


*/

import java.util.Arrays;

public class CanAttendMeetings {


  // Definition for an interval.
  public static class Interval {

    int start, end;

    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
  }

  public boolean canAttendMeetings(Interval[] intervals) {
    if (intervals == null || intervals.length == 0) return true;

    int n = intervals.length;
    int[] startingTimes = new int[n], endingTimes = new int[n];

    for (int i = 0; i < n; i++) {
      Interval interval = intervals[i];
      startingTimes[i] = interval.start;
      endingTimes[i] = interval.end;
    }

    Arrays.sort(startingTimes);
    Arrays.sort(endingTimes);

    for (int i = 1; i < n; i++) {
      if (startingTimes[i] < endingTimes[i-1]) {
        return false;
      }
    }
    return true;
  }

}
