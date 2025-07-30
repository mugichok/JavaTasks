import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class test {
    public static void main(String[] args) {
        // Параметры подключения
        String url = "jdbc:postgresql://localhost:5432/test_db";
        String user = "postgres";
        String password = "postgres";

        try {
            // 1. Регистрация драйвера (необязательно для JDBC 4.0+)
            Class.forName("org.postgresql.Driver");

            // 2. Попытка подключения
            try (Connection connection = DriverManager.getConnection(url, user, password)) {
                System.out.println("✅ Подключение к PostgreSQL успешно!");

                // 3. Дополнительная проверка
                System.out.println("Версия PostgreSQL: " +
                        connection.getMetaData().getDatabaseProductVersion());
            }
        } catch (ClassNotFoundException e) {
            System.err.println("❌ Драйвер PostgreSQL не найден!");
            System.err.println("Добавьте зависимость в pom.xml:");
            System.err.println("<dependency>");
            System.err.println("    <groupId>org.postgresql</groupId>");
            System.err.println("    <artifactId>postgresql</artifactId>");
            System.err.println("    <version>42.6.0</version>");
            System.err.println("</dependency>");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("❌ Ошибка подключения к PostgreSQL:");
            System.err.println("URL: " + url);
            System.err.println("User: " + user);

            // Расшифровка основных ошибок
            if (e.getMessage().contains("Connection refused")) {
                System.err.println("1. Проверьте, что PostgreSQL запущен");
                System.err.println("2. Проверьте хост и порт (по умолчанию 5432)");
            } else if (e.getMessage().contains("database \"test_db\" does not exist")) {
                System.err.println("База данных 'test_db' не существует!");
                System.err.println("Создайте БД: CREATE DATABASE test_db;");
            } else if (e.getMessage().contains("password authentication failed")) {
                System.err.println("Неверный логин/пароль");
            }

            e.printStackTrace();
        }
    }
}
