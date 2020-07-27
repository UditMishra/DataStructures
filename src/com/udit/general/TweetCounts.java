package com.udit.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TweetCounts {

	Map<String, List<Integer>> tweets = null;
	Map<String, Integer> incrValues = null;

	public TweetCounts() {
		tweets = new HashMap<>();
		incrValues = new HashMap<>();
		incrValues.put("minute", 60);
		incrValues.put("hour", 60 * 60);
		incrValues.put("day", 24 * 60 * 60);
	}

	public void recordTweet(String tweetName, int time) {
		List<Integer> intervals = tweets.get(tweetName);
		if (intervals != null) {
			intervals.add(time);
			Collections.sort(intervals);
		} else {
			intervals = new ArrayList<>();
			intervals.add(time);
		}
		tweets.put(tweetName, intervals);
	}

	static class Interval {
		private int start;
		private int end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public boolean inRange(int value) {
			return value >= start && value < end;
		}

		@Override
		public String toString() {
			return "[" + start + "-" + end + "]\n";
		}
	}

	private List<Interval> getAllPossibleIntervals(String freq, int startTime, int endTime) {
		List<Interval> intervals = new ArrayList<>();
		int interval = incrValues.get(freq);
		Interval first = new Interval(startTime, startTime > interval ? startTime + interval : interval);
		intervals.add(first);
		int myStart = first.start;
		int myEnd = first.end;
		while (endTime >= myEnd) {
			myStart = myEnd;
			myEnd = myEnd + interval;
			intervals.add(new Interval(myStart, myEnd));
		}
		return intervals;

	}

	public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
		List<Integer> freqList = new ArrayList<Integer>();

		if (tweets.isEmpty() || !tweets.containsKey(tweetName)) {
			return freqList;
		}
		List<Interval> allPossibleIntervals = getAllPossibleIntervals(freq, startTime, endTime);
		System.out.println(allPossibleIntervals);

		int count = 0;

		for (Interval interval : allPossibleIntervals) {
			count = 0;
			for (Integer tweet : tweets.get(tweetName)) {
				if (interval.inRange(tweet)) {
					count++;
				}
			}
			freqList.add(count);			
		}
		System.out.println(freqList.size());
		int[] d = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		System.out.println(d.length);
		return freqList;
	}

	public static void main(String[] args) {

		TweetCounts tweetCounts = new TweetCounts();
		
		tweetCounts.recordTweet("tweet0", 19);
		tweetCounts.recordTweet("tweet1", 34);
		tweetCounts.recordTweet("tweet2", 36);
		
		tweetCounts.recordTweet("tweet3", 59);
		tweetCounts.recordTweet("tweet4", 64);
		tweetCounts.recordTweet("tweet2", 48);
		
		tweetCounts.recordTweet("tweet4", 21);
		tweetCounts.recordTweet("tweet2", 44);
		
		System.out.println(tweetCounts.getTweetCountsPerFrequency("minute", "tweet1", 59, 9302));
		
	}
}
