class Solution {
    HashMap<String,Integer> indegrees = new HashMap<>();
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String,Set<String>> adj = buildAdj(recipes,ingredients,supplies);
        Set<String> rcp = Stream.of(recipes).collect(Collectors.toCollection(HashSet::new));
        Set<String> available = Stream.of(supplies).collect(Collectors.toCollection(HashSet::new));
        List<String> res = new ArrayList<>();

        for(String str : adj.keySet()){
            for(String ing : adj.get(str)){
                indegrees.put(ing,indegrees.getOrDefault(ing,0)+1);
            }
        }


        Queue<String> q = new LinkedList<>();

        for(String i : available){
            q.add(i);
        }

        while(!q.isEmpty()){
            String r = q.poll();
            if(rcp.contains(r)){
                res.add(r);
            }
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

        for(int i=0;i<recipes.length;i++){
            for(String ing : ingredients.get(i)){
                if(!adj.containsKey(ing)){
                    adj.put(ing, new HashSet<String>());
                }
                adj.get(ing).add(recipes[i]);
                //indegrees.put(ing,indegrees.getOrDefault(ing,0)+1);
            }
        }

        return adj;
    }
}