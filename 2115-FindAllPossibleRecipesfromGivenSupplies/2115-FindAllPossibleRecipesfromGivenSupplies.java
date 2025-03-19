class Solution {
    HashMap<String,Integer> indegrees = new HashMap<>();
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String,Set<String>> adj = buildAdj(recipes,ingredients,supplies);

        List<String> res = new ArrayList<>();

        Queue<String> q = new LinkedList<>();

        for(String r : indegrees.keySet()){
            if(indegrees.get(r)==0){
                q.add(r);
            }
        }

        while(!q.isEmpty()){
            String r = q.poll();
            res.add(r);
            if(!adj.containsKey(r)){
                continue;
            }
            for(String to : adj.get(r)){
                indegrees.put(to,indegrees.get(to)-1);

                if(indegrees.get(to)==0){
                    q.add(to);
                }
            }
        }

        return res;
    }

    public HashMap<String,Set<String>> buildAdj(String[] recipes, List<List<String>> ingredients, String[] supplies){
        HashMap<String,Set<String>> adj = new HashMap<>();
        Set<String> available = Stream.of(supplies).collect(Collectors.toCollection(HashSet::new));

        for(int i=0;i<recipes.length;i++){
            int count = 0;
            for(String ing : ingredients.get(i)){
                if(available.contains(ing)){
                    continue;
                }
                count++;
                if(!adj.containsKey(ing)){
                    adj.put(ing, new HashSet<String>());
                }
                adj.get(ing).add(recipes[i]);
            }
            indegrees.put(recipes[i],count);
        }

        return adj;
    }
}