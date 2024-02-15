package com.example.doumiproject.util;

public class PaginationUtil {

    private static int pageCriteria = 5;
    private static int PageCriteriaOffset = 2;

    public static int calculateStartIndex(int currentPage, int totalPages) {

        if (currentPage >= totalPages - PageCriteriaOffset) {
            return totalPages - pageCriteria + 1;
        }

        return Math.max(1, currentPage - PageCriteriaOffset);
    }

    public static int calculateEndIndex(int currentPage, int totalPages) {

        if (currentPage <= PageCriteriaOffset) {
            return pageCriteria;
        }

        return Math.min(totalPages, currentPage + PageCriteriaOffset);
    }
}
