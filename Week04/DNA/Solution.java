import java.util.*;

class KMP_String_Matching {
    List<Integer> KMPSearch(String pat, String txt, int divider) {
        int M = pat.length();
        int N = txt.length();

        int[] lps = new int[M];
        int j = 0; // index for pat[]

        computeLPSArray(pat, M, lps);

        List<Integer> indices = new ArrayList<>(); // a list of where the STR pat index on
        List<Integer> counts = new ArrayList<>(); //for each index, keep track of how many times the pat repeats itself

        int i = 0;
        int count = 1; // to count instances of consecutive patterns
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                int index = i - j;
                j = lps[j - 1];
                indices.add(index);
            } else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }

        if (indices.size() == 1) {
            counts.add(1); //only one match occurred
        }

        for (int g = 0; g < indices.size() - 1; g++) {
            if (indices.get(g) + divider == indices.get(g + 1)) {
                count = count + 1; //if the next pat is the same, increase count
            }
            if (indices.get(g) + divider == indices.get(indices.size() - 1)) {
                counts.add(count); //if there are only 2 occurrences of the pat & that makes up the whole string
                count = 1; //reset count
            }
            if (indices.get(g) + divider != indices.get(g + 1)) {
                counts.add(count); //if no pattern in-between, then this will add the occurrences of the pat
                count = 1; // reset count
            }

        }
        if (indices.size() > 1) {
            if (indices.get(indices.size() - 2) + divider != indices.get(indices.size() - 1)) {
                counts.add(1);
            } //to account for the end pattern if it's not a repeating pat
        }

        return counts;

    }


    int KMPSearch(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();

        int[] lps = new int[M];
        int j = 0; // index for pat[]

        computeLPSArray(pat, M, lps);

        int i = 0;
        int res = 0;
        int next_i = 0;

        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {

                j = lps[j - 1];
                res++;

                if (lps[j] != 0)
                    i = ++next_i;
                j = 0;
            } else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
        return res;
    }

    void computeLPSArray(String pat, int M, int[] lps) {

        int len = 0;
        int i = 1;
        lps[0] = 0;

        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];


                } else {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }

}

class Solution {
    public static void main(String[] args) {
        HashMap<String, List<Integer>> map = new LinkedHashMap<>(); //map to collect person's name and list of STRs counts
        List<String> names = new ArrayList<>(); // list of all names
        Scanner in = new Scanner(System.in);
        String input = in.nextLine().trim().replaceAll("  +", " ");
        String[] STRs = input.split(" "); //an array of the STRs
        int noOfSTRs = Integer.parseInt(STRs[0]);
        int peopleDatabase = Integer.parseInt(in.nextLine());

        //to add every person as a key-value pair in a hashmap
        for (int i = 0; i < peopleDatabase; i++) {
            String person = in.nextLine().trim().replaceAll("  +", " ");
            String[] data = person.split(" "); //an array of the person's name + STR count
            List<Integer> strData = new ArrayList<>();
            names.add(data[0]);
            for (int j = 1; j <= noOfSTRs; j++) {
                strData.add(Integer.valueOf(data[j]));
            }
            map.put(data[0], strData);
        }

        int testCases = Integer.parseInt(in.nextLine());

        List<String> who = null;
        //for every DNA input
        for (int k = 0; k < testCases; k++) {
            String DNA = in.nextLine();
            who = new ArrayList<>(); //keep track of who matched the STRs

            //with every input, parse out STRs and match them to people
            for (int v = 1; v <= noOfSTRs; v++) {
                List<Integer> STRMatches = new KMP_String_Matching().KMPSearch(STRs[v], DNA, STRs[v].length());
                int numMatch = new KMP_String_Matching().KMPSearch(STRs[v], DNA); //num match is only for 0s
                String name = ""; // keeping track of name that had an STR match to be added to a list
                for (String key : map.keySet()) {
                    List<Integer> listPerName = map.get(key);
                    int indexValue = listPerName.get(v - 1); // gets the corresponding STR count per person
                    if (numMatch == 0 && indexValue == 0) {
                        name = name + key;
                        //accounts for 0 matches
                    }

                    if (STRMatches.isEmpty() != true && Collections.max(STRMatches) == indexValue) {
                        name = name + key;
                        //if you find the max pat occurrence to match the person, helps avoid having duplicate matches
                        //else if only occurs if the max doesn't come up

                    } else if (STRMatches.contains(indexValue)) {
                        name = name + key;
                    }
                }
                who.add(name);
            }

            int matched = 0; //matches w/ list of names created from matching STRs -
            // if appear # of STRs times, then count this
            int found = 0; //found is when there's a match for every pat
            int sum = 0; // used to sort the names
            String nameMatch = "";
            List<String> namesMatched = new ArrayList<>();
            List<String> namesMatchedSorted = new ArrayList<>();


            for (int z = 0; z < names.size(); z++) {
                for (String whoString : who) {

                    int ans = new KMP_String_Matching().KMPSearch(names.get(z), whoString);
                    if (ans > 0) {
                        matched = matched + 1;
                    }
                    if (matched == noOfSTRs) {
                        found = found + 1;
                        namesMatched.add(names.get(z));
                        nameMatch = nameMatch + names.get(z);
                    }
                }
                matched = 0;
            }

            if (found == 1) {
                System.out.println("Case #" + (k + 1) + ": " + nameMatch);
            }
            if (found == 0) {
                System.out.println("Case #" + (k + 1) + ": " + "No match");
            }   else if (found > 1) {
                for (String name : namesMatched) {
                    List<Integer> listPerMatchedName = map.get(name);
                    int sumOfMatch = listPerMatchedName.stream().mapToInt(Integer::intValue).sum();
                    if (sumOfMatch > sum) {
                        sum = sumOfMatch;
                        namesMatchedSorted.add(name);
                    }
                }
                System.out.println("Case #" + (k + 1) + ": " + namesMatchedSorted.get(namesMatchedSorted.size() - 1));
            }
        }
    }
}
