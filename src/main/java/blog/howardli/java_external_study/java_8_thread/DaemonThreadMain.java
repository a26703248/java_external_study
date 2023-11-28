package blog.howardli.java_external_study.java_8_thread;

import java.util.Scanner;
import java.util.concurrent.*;

public class DaemonThreadMain {
    public static void main(String[] args) {
        // 建立 ExecutorService
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // 執行長期任務
        executorService.execute(() -> {
            while (true) {
                // 在這裡執行你的長期任務邏輯
                System.out.println("Running long-term task...");

                try {
                    Thread.sleep(1000); // 模擬長期執行的任務
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 監聽用戶輸入以停止應用程序
        listenForStopCommand(executorService);
    }

    private static void listenForStopCommand(ExecutorService executorService) {
        Scanner scanner = new Scanner(System.in);

        // 使用新的執行緒來等待用戶輸入
        Thread userInputThread = new Thread(() -> {
            System.out.println("Type 'stop' to stop the application.");
            while (true) {
                String userInput = scanner.nextLine();
                if ("stop".equalsIgnoreCase(userInput)) {
                    // 用戶輸入 "stop"，停止應用程序
                    executorService.shutdown();
                    break;
                }
            }
        });

        // 啟動用戶輸入監聽執行緒
        userInputThread.start();

        // 等待用戶輸入執行緒結束
        try {
            userInputThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 關閉掃描器
        scanner.close();
    }
}
