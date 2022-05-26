public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> d = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            d.addLast(word.charAt(i));
        }
        return d;
    }

    public boolean isPalindrome(String word) {
//        if (word.length() == 0 || word == null) {
//            return true;
//        }
//        int left = 0;
//        int right = word.length() - 1;
//        for (int i = 0; i <= word.length()/2; i++) {
//            if (word.charAt(left) == word.charAt(right)) {
//                left += 1;
//                right -= 1;
//            } else {
//                return false;
//            }
//        }
//        return true;
        if (word == null || word.isEmpty()) {
            return true;
        }
        Deque d = wordToDeque(word);
        return isPalindromehelper(d);
    }

    private boolean isPalindromehelper(Deque word) {
        if (word.size() <= 1) {
            return true;
        }
        if (word.removeFirst() != word.removeLast()) {
            return false;
        }
        return isPalindromehelper(word);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word == null || word.isEmpty()) {
            return true;
        }
        Deque d = wordToDeque(word);
        return isPalindromehelper2(d,cc);
    }

    private boolean isPalindromehelper2(Deque word,CharacterComparator cc) {
        if (word.size() <= 1) {
            return true;
        }

        if (!cc.equalChars((char)word.removeFirst(),(char)word.removeLast())) {
            return false;
        }
        return isPalindromehelper2(word,cc);
    }

}
