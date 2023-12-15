class Solution {
    private Map<String, String> destCity = new HashMap<>();
    
    public String destCity(List<List<String>> paths) {
        for (int i = 0; i < paths.size(); i++) {
            List<String> dest = paths.get(i);
            destCity.put(dest.get(0), dest.get(1));
        }
        return nextCity(paths.get(0).get(0));
    }

    private String nextCity(String currCity) {
        String nextCity = destCity.get(currCity);
        if (nextCity == null) return currCity;
        return nextCity(nextCity);
    }
}