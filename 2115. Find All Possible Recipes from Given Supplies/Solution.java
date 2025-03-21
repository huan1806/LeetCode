class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> allSupplies = new HashSet<>(Arrays.asList(supplies));
        Set<String> uncreatable = new HashSet<>();
        Map<String, List<String>> recipesMap = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            recipesMap.put(recipes[i], ingredients.get(i));
        }
        List<String> result = new ArrayList<>();
        for (String recipe : recipes) {
            if (allSupplies.contains(recipe) || creatable(recipe, recipesMap, uncreatable, allSupplies)) {
                result.add(recipe);
            }
        }
        return result;
    }

    private boolean creatable(String recipe, Map<String, List<String>> recipesMap, Set<String> uncreatable, Set<String> allSupplies) {
        uncreatable.add(recipe);
        for (String ingredient : recipesMap.get(recipe)) {
            if (!allSupplies.contains(ingredient)) {
                if (uncreatable.contains(ingredient) || !recipesMap.containsKey(ingredient) || !creatable(ingredient,
                        recipesMap, uncreatable, allSupplies)) {
                    uncreatable.add(ingredient);
                    return false;
                }
                allSupplies.add(ingredient);
            }
        }
        uncreatable.remove(recipe);
        allSupplies.add(recipe);
        return true;
    }
}