class FoodRatings {

    HashMap<String, TreeMap<String, Integer>> map;
    HashMap<String, Integer> rankMap;
    HashMap<String, String> typeMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        map = new HashMap<>();
        rankMap = new HashMap<>();
        typeMap = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            typeMap.put(foods[i], cuisines[i]);
            rankMap.put(foods[i], ratings[i]);

            map.putIfAbsent(cuisines[i], new TreeMap<>(getRankComparator()));
            map.get(cuisines[i]).put(foods[i], ratings[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = typeMap.get(food);
        TreeMap<String, Integer> temp = map.get(cuisine);

        temp.remove(food);

        rankMap.put(food, newRating);

        temp.put(food, newRating);
    }

    public String highestRated(String cuisine) {
        TreeMap<String, Integer> temp = map.get(cuisine);
        return temp.firstKey();
    }

    private Comparator<String> getRankComparator() {
        return (k1, k2) -> {
            int cmp = rankMap.get(k2).compareTo(rankMap.get(k1));
            if (cmp == 0) return k1.compareTo(k2);
            return cmp;
        };
    }
}
