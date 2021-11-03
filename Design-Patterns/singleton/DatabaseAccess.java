import java.time.LocalDateTime;

public class DatabaseAccess {
    private final String jdbcUrl;
    private final LocalDateTime createdAt;
    private static DatabaseAccess databaseAccess;

    private DatabaseAccess(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
        this.createdAt = LocalDateTime.now();
    }

    public static DatabaseAccess getInstance(String jdbcUrl) {
        if (databaseAccess == null) {
            databaseAccess = new DatabaseAccess(jdbcUrl);
        }
        return databaseAccess;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
