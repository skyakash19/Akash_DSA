class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int L = beginWord.length();

        Map<String, List<String>> allComboDict = new HashMap<>();

        wordList.forEach( word -> {
            for (int i = 0; i < L; i++) {
               
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                transformations.add(word);
                allComboDict.put(newWord, transformations);
            }
        });
        Queue<Pair<String, Integer>> Q = new LinkedList<>();
        Q.add(new Pair(beginWord, 1));

        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!Q.isEmpty()) {
            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < L; i++) {

                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                  
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                   
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        Q.add(new Pair(adjacentWord, level + 1));
                    }
                }
            }
        }

        return 0;
    }
}
