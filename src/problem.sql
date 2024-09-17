WITH RankedBalances AS (
    SELECT
        CLIENT_NAME,
        CLIENT_BALANCE_DATE,
        CLIENT_BALANCE_VALUE,
        ROW_NUMBER() OVER (
            PARTITION BY CLIENT_NAME, CLIENT_BALANCE_DATE, CLIENT_BALANCE_VALUE
            ORDER BY (SELECT NULL)
        ) AS rn
    FROM ClientBalance
)
DELETE FROM ClientBalance
WHERE (CLIENT_NAME, CLIENT_BALANCE_DATE, CLIENT_BALANCE_VALUE) IN (
    SELECT CLIENT_NAME, CLIENT_BALANCE_DATE, CLIENT_BALANCE_VALUE
    FROM RankedBalances
    WHERE rn > 1
);