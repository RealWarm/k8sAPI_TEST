//package io.kubernetes.client.combine;
//
//import io.kubernetes.client.openapi.ApiClient;
//import io.kubernetes.client.openapi.Configuration;
//import io.kubernetes.client.util.Config;
//import io.kubernetes.client.openapi.models.V1Config;
//import io.kubernetes.client.openapi.models.V1Context;
//
//import java.io.IOException;
//import java.util.List;
//
//public class KubernetesContextRetriever {
//
//    public void listKubeContexts() {
//        try {
//            // Kubernetes API 클라이언트 설정
//            ApiClient client = Config.defaultClient();
//            Configuration.setDefaultApiClient(client);
//
//            // 현재 kubeconfig 파일에서 컨텍스트 목록 가져오기
//            V1Config kubeConfig = Config.loadKubeConfig();
//            List<V1Context> contexts = kubeConfig.getContexts();
//
//            // 컨텍스트 목록 출력
//            for (V1Context context : contexts) {
//                System.out.println("Context Name: " + context.getName());
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("Error occurred while fetching contexts.");
//        }
//    }
//
//    public static void main(String[] args) {
//        ApiClient client = new ApiClient();
//        client.setBasePath("https://5302E4D20BD5556D8BE3B85E635F1DAE.gr7.ap-northeast-2.eks.amazonaws.com");
//        client.setApiKey("Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6InF5a2NsWElJMjNZTlNNRU03X3V4eERkd0NYcmZNbEhTZjZnb2gyQXFvYlkifQ.eyJpc3MiOiJrdWJlcm5ldGVzL3NlcnZpY2VhY2NvdW50Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9uYW1lc3BhY2UiOiJkZWZhdWx0Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9zZWNyZXQubmFtZSI6ImNsb2l0LWRldi1zZWNyZXQiLCJrdWJlcm5ldGVzLmlvL3NlcnZpY2VhY2NvdW50L3NlcnZpY2UtYWNjb3VudC5uYW1lIjoiY2xvaXQtZGV2LXNhIiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9zZXJ2aWNlLWFjY291bnQudWlkIjoiY2U1MzVlMWYtNzM1ZC00YjVjLTk0MTAtZTRlMDhjY2RjY2QzIiwic3ViIjoic3lzdGVtOnNlcnZpY2VhY2NvdW50OmRlZmF1bHQ6Y2xvaXQtZGV2LXNhIn0.olP2AXIFQ0OydTWNPr_PMBUqVVAMmCwqPZXMpkSQI7jGl65MDDMioovk4-t9prxAhN0ZbTJ4hAeKuD7UvuvNy3AHj5qXDpZ80e7NoZIAIKXqmN_IxtSv9bkU3cwbH5V-yocGVj_oBm8Ok0LuTXPLO0NYlo5gbt8nJdBNCBhGTqOnLgjpARwJV6I2xuOTft4Zbs-CGbO7aYd4_e_drBIz8jdI_lEtB7JnydS_3zzUlOKGya2ZiEfxN-gXrherBuvvDRPT7GaG4Aj9HLaNLTl0Hz8staKUvshhJuE4WjKuCilILSL1D2mE0TPS3BBBP0BSXFRKiHsarZndo5L7Z-0VxQ");
//        client.setVerifyingSsl(false);
//
//        KubernetesContextRetriever retriever = new KubernetesContextRetriever();
//        retriever.listKubeContexts();
//    }
//}