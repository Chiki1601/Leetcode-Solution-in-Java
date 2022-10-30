class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        List<List<String>> result = new LinkedList<>();
        Map<String, CreatorNode> map = new HashMap<>();
        int length = creators.length, viewCount;
        long maxViewCount = 0;
        List<String> popularCreators = new LinkedList<>();
        String creator, id;
        CreatorNode temp;

        for (int index = 0; index < length; index++){
            creator = creators[index];
            viewCount = views[index];
            id = ids[index];
            if (map.containsKey(creator)){
                temp = map.get(creator);
                temp.totalViewCount += viewCount;
                if (temp.maxViews < viewCount){
                    temp.maxViews = viewCount;
                    temp.popularVideo = id;
                } else if (temp.maxViews == viewCount){
                    temp.popularVideo = (id.compareTo(temp.popularVideo) < 0) ? id  : temp.popularVideo;
                }
            } else {
                temp = new CreatorNode(viewCount, viewCount, id);
                map.put(creator, temp);
            }

            if (maxViewCount < temp.totalViewCount){
                maxViewCount = temp.totalViewCount;
                popularCreators.clear();
                popularCreators.add(creator);
            } else if (maxViewCount == temp.totalViewCount){
                popularCreators.add(creator);
            }
        }

        for (String tempCreator : popularCreators){
            result.add(new LinkedList<>(Arrays.asList(tempCreator, map.get(tempCreator).popularVideo)));
        }

        return result;
    }
    static class CreatorNode {
        long totalViewCount;
        int maxViews;
        String popularVideo;

        public CreatorNode(long totalViewCount, int maxViews, String popularVideo) {
            this.totalViewCount = totalViewCount;
            this.maxViews = maxViews;
            this.popularVideo = popularVideo;
        }
    }
}
