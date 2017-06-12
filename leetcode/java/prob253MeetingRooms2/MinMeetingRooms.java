/*
Problem 253. Meeting Rooms II

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.

*/

/*
PSEUDOCODE

We initiate 2 arrays startingTimes and endingTimes; startingTimes will contain the beginings of all the meetings
whereas endingTimes will contain the ending of meetings.
We sort these 2 arrays.

We initialize rooms and endIndex to 0; rooms represents the minimum number of rooms and endIndex points to endingTimes.

When do we increment rooms?
    Whenever a new meeting is starting, we check if there is a meeting that has just ended. if so, we just use the same room that ended.
    However, if the previous meeting has not ended, we will then need to book a new room, therefore we increment rooms by 1.

We iterate over array startingTimes.
    . If startingTimes[startIndex] < endingTimes[endIndex], meaning that the new meeting is starting before the previous
    one ends, so we will need a new room for this new meeting. We therefore increment rooms by 1.
    . Otherwise (startingTimes[startIndex] >= endingTimes[endIndex]), we just increment endIndex by 1. This means that the
    new meeting is starting after the previous meeting has ended, so we just use the one that just ended.
    We then increment endIndex by 1 to point to the next ending meeting

Example: meeting1 = [0, 10], meeting2 = [5, 15], meeting3 = [11, 30]
    startingTimes = [0, 5, 11], and endingTimes = [10, 15, 30]
    rooms = 0, endIndex = 0;

    . startIndex = 0;
        We see that the first meeting to start begins at time 0 and the earliest meeting to end finishes at time 10.
        Since 0 < 10, we need to book a new room for this new meeting, so rooms get incremented by 1 to become 1.
    . startIndex = 1:
        The next meeting starts at time 5. But at this time, no meeing has ended yet since the next meeting to end
        finishes at time 10 (endIndex = 0). Since 5 < 10, we therefore need a new room for this new meeting.
        rooms get incremented by 1 to become 2.
    . startIndex = 2:
        The next meeting starts at time 11. At this time, there is a meeting that ended at time 10, thus that room is
        available for use. We therefore don't need a new room; we just use the same room that just ended at time 10.
        We then increment endIndex by 1. endIndex now points to 15 in endingTimes.
We therefore need a minimun of 2 rooms for these 3 meetings.

*/

import java.util.Arrays;

public class MinMeetingRooms {

  public static class Interval {
    int start, end;
    public Interval() {
      start = 0;
      end = 0;
    }
    public Interval(int s, int e) {
      start = s;
      end = e;
    }
  }

  public int minMeetingRooms(Interval[] intervals) {
    if (intervals == null || intervals.length == 0) return 0;

    int n = intervals.length;
    int[] startingTimes = new int[n], endingTimes = new int[n];

    for (int i = 0; i < n; i++) {
      Interval interval = intervals[i];
      startingTimes[i] = interval.start;
      endingTimes[i] = interval.end;
    }

    Arrays.sort(startingTimes);
    Arrays.sort(endingTimes);

    int rooms = 0, endIndex = 0;

    for (int startIndex = 0; startIndex < n; startIndex++) {
      if (startingTimes[startIndex] < endingTimes[endIndex]) {
        rooms++;
      } else {
        endIndex++;
      }
    }
    return rooms;
  }
}
