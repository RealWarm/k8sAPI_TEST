//package io.kubernetes.client.combine;
//
//import io.kubernetes.client.openapi.ApiClient;
//import io.kubernetes.client.openapi.ApiException;
//import io.kubernetes.client.openapi.Configuration;
//import io.kubernetes.client.openapi.apis.BatchV1Api;
//import io.kubernetes.client.openapi.models.V1JobList;
//import io.kubernetes.client.openapi.models.V1NodeList;
//import io.kubernetes.client.openapi.models.V1PodList;
//import io.kubernetes.client.util.Config;
//
//public class KubernetesJobsExample {
//    public static void main(String[] args) {
//        try {
//            // Kubernetes 클러스터에 연결
//            ApiClient client = Config.defaultClient();
//            Configuration.setDefaultApiClient(client);
//
//            // CoreV1Api 객체 생성
//            CoreV1Api coreApi = new CoreV1Api();
//
//            // 노드 목록 가져오기
//            V1NodeList nodeList = coreApi.listNode(
//                    null,    // pretty
//                    null,    // allowWatchBookmarks
//                    null,    // continue
//                    null,    // fieldSelector
//                    null,    // labelSelector
//                    null,    // limit
//                    null,    // resourceVersion
//                    null,    // timeoutSeconds
//                    null     // watch
//            );
//
//            // 노드 목록 출력
//            System.out.printf("%-15s %-10s %-10s %-8s %-15s%n", "NAME", "STATUS", "ROLES", "AGE", "VERSION");
//            for (var node : nodeList.getItems()) {
//                String name = node.getMetadata().getName();
//                String status = node.getStatus().getConditions().stream()
//                        .filter(cond -> "Ready".equals(cond.getType()))
//                        .findFirst()
//                        .map(cond -> cond.getStatus())
//                        .orElse("Unknown");
//                String roles = node.getMetadata().getLabels().getOrDefault("node-role.kubernetes.io/master", "<none>");
//                String age = ""; // 노드 나이는 별도로 계산해야 함
//                String version = node.getStatus().getNodeInfo().getKubeletVersion();
//
//                System.out.printf("%-15s %-10s %-10s %-8s %-15s%n", name, status, roles, age, version);
//            }
//
//        } catch (ApiException e) {
//            System.err.println("Exception when calling CoreV1Api#listNode");
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//
//
////try {
////        // Kubernetes 클러스터에 연결
////        ApiClient client = new ApiClient();
////        client.setBasePath("https://5302E4D20BD5556D8BE3B85E635F1DAE.gr7.ap-northeast-2.eks.amazonaws.com");
////        client.setApiKey("Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6InF5a2NsWElJMjNZTlNNRU03X3V4eERkd0NYcmZNbEhTZjZnb2gyQXFvYlkifQ.eyJpc3MiOiJrdWJlcm5ldGVzL3NlcnZpY2VhY2NvdW50Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9uYW1lc3BhY2UiOiJkZWZhdWx0Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9zZWNyZXQubmFtZSI6ImNsb2l0LWRldi1zZWNyZXQiLCJrdWJlcm5ldGVzLmlvL3NlcnZpY2VhY2NvdW50L3NlcnZpY2UtYWNjb3VudC5uYW1lIjoiY2xvaXQtZGV2LXNhIiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9zZXJ2aWNlLWFjY291bnQudWlkIjoiY2U1MzVlMWYtNzM1ZC00YjVjLTk0MTAtZTRlMDhjY2RjY2QzIiwic3ViIjoic3lzdGVtOnNlcnZpY2VhY2NvdW50OmRlZmF1bHQ6Y2xvaXQtZGV2LXNhIn0.olP2AXIFQ0OydTWNPr_PMBUqVVAMmCwqPZXMpkSQI7jGl65MDDMioovk4-t9prxAhN0ZbTJ4hAeKuD7UvuvNy3AHj5qXDpZ80e7NoZIAIKXqmN_IxtSv9bkU3cwbH5V-yocGVj_oBm8Ok0LuTXPLO0NYlo5gbt8nJdBNCBhGTqOnLgjpARwJV6I2xuOTft4Zbs-CGbO7aYd4_e_drBIz8jdI_lEtB7JnydS_3zzUlOKGya2ZiEfxN-gXrherBuvvDRPT7GaG4Aj9HLaNLTl0Hz8staKUvshhJuE4WjKuCilILSL1D2mE0TPS3BBBP0BSXFRKiHsarZndo5L7Z-0VxQ");
////        client.setVerifyingSsl(false);
////        Configuration.setDefaultApiClient(client);
////
////        // BatchV1Api 객체 생성
////        BatchV1Api batchApi = new BatchV1Api();
////
////        // 모든 네임스페이스의 Job 목록 가져오기
////        V1JobList jobList = batchApi.listJobForAllNamespaces(null, null, null, null, null, null, null, null, null, null);
////
////        // Job 목록 출력
////        jobList.getItems().forEach(job -> {
////        System.out.println("Job Name: " + job.getMetadata().getName());
////        System.out.println("Namespace: " + job.getMetadata().getNamespace());
////        System.out.println("Completion Status: " + job.getStatus().getSucceeded());
////        System.out.println("-----------");
////        });
////
////        } catch (ApiException e) {
////        System.err.println("Exception when calling BatchV1Api#listJobForAllNamespaces");
////        e.printStackTrace();
////        } catch (Exception e) {
////        e.printStackTrace();
////        }