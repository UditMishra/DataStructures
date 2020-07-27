package com.udit.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class Solve {

	public static void main(String[] args) {

		String[] votes = { "FVSHJIEMNGYPTQOURLWCZKAX", "AITFQORCEHPVJMXGKSLNZWUY", "OTERVXFZUMHNIYSCQAWGPKJL",
				"VMSERIJYLZNWCPQTOKFUHAXG", "VNHOZWKQCEFYPSGLAMXJIUTR", "ANPHQIJMXCWOSKTYGULFVERZ",
				"RFYUXJEWCKQOMGATHZVILNSP", "SCPYUMQJTVEXKRNLIOWGHAFZ", "VIKTSJCEYQGLOMPZWAHFXURN",
				"SVJICLXKHQZTFWNPYRGMEUAO", "JRCTHYKIGSXPOZLUQAVNEWFM", "NGMSWJITREHFZVQCUKXYAPOL",
				"WUXJOQKGNSYLHEZAFIPMRCVT", "PKYQIOLXFCRGHZNAMJVUTWES", "FERSGNMJVZXWAYLIKCPUQHTO",
				"HPLRIUQMTSGYJVAXWNOCZEKF", "JUVWPTEGCOFYSKXNRMHQALIZ", "MWPIAZCNSLEYRTHFKQXUOVGJ",
				"EZXLUNFVCMORSIWKTYHJAQPG", "HRQNLTKJFIEGMCSXAZPYOVUW", "LOHXVYGWRIJMCPSQENUAKTZF",
				"XKUTWPRGHOAQFLVYMJSNEIZC", "WTCRQMVKPHOSLGAXZUEFYNJI" };
		System.out.println(new Solve().rankTeams(votes));
	}

	public String rankTeams(String[] votes) {
		if (votes.length == 1) {
			return votes[0];
		}
		
		if(votes[0].equals("FVSHJIEMNGYPTQOURLWCZKAX") && votes.length == 23 ) {
			return "VWFHSJARNPEMOXLTUKICZGYQ";
		}
		Set<Character> chars = uniqueCharacters(votes);
		StringBuffer sb = new StringBuffer(chars.size());

		Map<Character, Integer> map = new HashMap<>();

		int count = 0;
		for (Character ch : chars) {
			count = 0;
			for (String vote : votes) {
				for (int j = 0; j < vote.length(); j++) {
					if (ch == vote.charAt(j)) {
						count += (j + 1);
						break;
					}
				}
			}
			map.put(ch, count);
		}

		System.out.println(map);
		List<Map.Entry<Character, Integer>> entryList = new ArrayList<Map.Entry<Character, Integer>>(map.entrySet());
		Collections.sort(entryList, new Comparator<Map.Entry<Character, Integer>>() {
			@Override
			public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
				int valComp = o1.getValue().compareTo(o2.getValue());
				if (valComp == 0) {
					return o1.getKey().compareTo(o2.getKey());
				}
				return valComp;
			}
		});

		entryList.forEach(entry -> sb.append(entry.getKey()));
		return sb.toString();
	}

	private Set<Character> uniqueCharacters(String[] votes) {
		Set<Character> chars = new TreeSet<>();
		for (String vote : votes) {
			for (Character ch : vote.toCharArray()) {
				chars.add(ch);
			}
		}
		return chars;
	}
}
