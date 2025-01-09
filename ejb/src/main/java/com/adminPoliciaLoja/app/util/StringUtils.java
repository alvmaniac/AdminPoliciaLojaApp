 package com.adminPoliciaLoja.app.util;

 public class StringUtils
 {
   public static final String EMPTY = "";
   public static final int INDEX_NOT_FOUND = -1;

   public static boolean isEmpty(String str)
   {
     return (str == null) || (str.length() == 0);
   }
 
   public static boolean isNotEmpty(String str)
   {
     return !isEmpty(str);
   }
 
   public static boolean isBlank(String str)
   {
     int strLen;
     if ((str == null) || ((strLen = str.length()) == 0)) {
       return true;
     }
     for (int i = 0; i < strLen; i++) {
       if (!Character.isWhitespace(str.charAt(i))) {
         return false;
       }
     }
     return true;
   }
 
   public static boolean isNotBlank(String str)
   {
     return !isBlank(str);
   }
 
   /** @deprecated */
   public static String clean(String str)
   {
     return str == null ? "" : str.trim();
   }
 
   public static String trim(String str)
   {
     return str == null ? null : str.trim();
   }
 
   public static String trimToNull(String str)
   {
     String ts = trim(str);
     return isEmpty(ts) ? null : ts;
   }
 
   public static String trimToEmpty(String str)
   {
     return str == null ? "" : str.trim();
   }
 
   public static String strip(String str)
   {
     return strip(str, null);
   }
 
   public static String stripToNull(String str)
   {
     if (str == null) {
       return null;
     }
     str = strip(str, null);
     return str.length() == 0 ? null : str;
   }
 
   public static String stripToEmpty(String str)
   {
     return str == null ? "" : strip(str, null);
   }
 
   public static String strip(String str, String stripChars)
   {
     if (isEmpty(str)) {
       return str;
     }
     str = stripStart(str, stripChars);
     return stripEnd(str, stripChars);
   }
 
   public static String stripStart(String str, String stripChars)
   {
     int strLen;
     if ((str == null) || ((strLen = str.length()) == 0)) {
       return str;
     }
     int start = 0;
     if (stripChars == null) {
       do {
         start++;
 
         if (start == strLen) break; 
       }while (Character.isWhitespace(str.charAt(start)));
     }
     else {
       if (stripChars.length() == 0) {
         return str;
       }
       do
         start++;
       while ((start != strLen) && (stripChars.indexOf(str.charAt(start)) != -1));
     }
 
     return str.substring(start);
   }
 
   public static String stripEnd(String str, String stripChars)
   {
     int end;
     if ((str == null) || ((end = str.length()) == 0)) {
       return str;
     }
 
     if (stripChars == null) {
       do {
         end--;
 
         if (end == 0) break; 
       }while (Character.isWhitespace(str.charAt(end - 1)));
     }
     else {
       if (stripChars.length() == 0) {
         return str;
       }
       do
         end--;
       while ((end != 0) && (stripChars.indexOf(str.charAt(end - 1)) != -1));
     }
 
     return str.substring(0, end);
   }
 
   public static String[] stripAll(String[] strs)
   {
     return stripAll(strs, null);
   }
 
   public static String[] stripAll(String[] strs, String stripChars)
   {
     int strsLen;
     if ((strs == null) || ((strsLen = strs.length) == 0)) {
       return strs;
     }
     String[] newArr = new String[strsLen];
     for (int i = 0; i < strsLen; i++) {
       newArr[i] = strip(strs[i], stripChars);
     }
     return newArr;
   }
 
   public static boolean equals(String str1, String str2)
   {
     return str1 == null ? false : str2 == null ? true : str1.equals(str2);
   }
 
   public static boolean equalsIgnoreCase(String str1, String str2)
   {
     return str1 == null ? false : str2 == null ? true : str1.equalsIgnoreCase(str2);
   }
 
   public static int indexOf(String str, char searchChar)
   {
     if (isEmpty(str)) {
       return -1;
     }
     return str.indexOf(searchChar);
   }
 
   public static int indexOf(String str, char searchChar, int startPos)
   {
     if (isEmpty(str)) {
       return -1;
     }
     return str.indexOf(searchChar, startPos);
   }
 
   public static int indexOf(String str, String searchStr)
   {
     if ((str == null) || (searchStr == null)) {
       return -1;
     }
     return str.indexOf(searchStr);
   }
 
   public static int ordinalIndexOf(String str, String searchStr, int ordinal)
   {
     if ((str == null) || (searchStr == null) || (ordinal <= 0)) {
       return -1;
     }
     if (searchStr.length() == 0) {
       return 0;
     }
     int found = 0;
     int index = -1;
     do {
       index = str.indexOf(searchStr, index + 1);
       if (index < 0) {
         return index;
       }
       found++;
     }while (found < ordinal);
     return index;
   }
 
   public static int indexOf(String str, String searchStr, int startPos)
   {
     if ((str == null) || (searchStr == null)) {
       return -1;
     }
 
     if ((searchStr.length() == 0) && (startPos >= str.length())) {
       return str.length();
     }
     return str.indexOf(searchStr, startPos);
   }
 
   public static int lastIndexOf(String str, char searchChar)
   {
     if (isEmpty(str)) {
       return -1;
     }
     return str.lastIndexOf(searchChar);
   }
 
   public static int lastIndexOf(String str, char searchChar, int startPos)
   {
     if (isEmpty(str)) {
       return -1;
     }
     return str.lastIndexOf(searchChar, startPos);
   }
 
   public static int lastIndexOf(String str, String searchStr)
   {
     if ((str == null) || (searchStr == null)) {
       return -1;
     }
     return str.lastIndexOf(searchStr);
   }
 
   public static int lastIndexOf(String str, String searchStr, int startPos)
   {
     if ((str == null) || (searchStr == null)) {
       return -1;
     }
     return str.lastIndexOf(searchStr, startPos);
   }
 
   public static boolean contains(String str, char searchChar)
   {
     if (isEmpty(str)) {
       return false;
     }
     return str.indexOf(searchChar) >= 0;
   }
 
   public static boolean contains(String str, String searchStr)
   {
/* 1031 */     if ((str == null) || (searchStr == null)) {
/* 1032 */       return false;
     }
/* 1034 */     return str.indexOf(searchStr) >= 0;
   }
 
   public static boolean containsIgnoreCase(String str, String searchStr)
   {
/* 1061 */     if ((str == null) || (searchStr == null)) {
/* 1062 */       return false;
     }
/* 1064 */     return contains(str.toUpperCase(), searchStr.toUpperCase());
   }


 
   public static int indexOfAnyBut(String str, String searchChars)
   {
/* 1198 */     if ((isEmpty(str)) || (isEmpty(searchChars))) {
/* 1199 */       return -1;
     }
/* 1201 */     for (int i = 0; i < str.length(); i++) {
/* 1202 */       if (searchChars.indexOf(str.charAt(i)) < 0) {
/* 1203 */         return i;
       }
     }
/* 1206 */     return -1;
   }
 

 

 
   public static boolean containsNone(String str, char[] invalidChars)
   {
/* 1300 */     if ((str == null) || (invalidChars == null)) {
/* 1301 */       return true;
     }
/* 1303 */     int strSize = str.length();
/* 1304 */     int validSize = invalidChars.length;
/* 1305 */     for (int i = 0; i < strSize; i++) {
/* 1306 */       char ch = str.charAt(i);
/* 1307 */       for (int j = 0; j < validSize; j++) {
/* 1308 */         if (invalidChars[j] == ch) {
/* 1309 */           return false;
         }
       }
     }
/* 1313 */     return true;
   }
 
   public static boolean containsNone(String str, String invalidChars)
   {
/* 1339 */     if ((str == null) || (invalidChars == null)) {
/* 1340 */       return true;
     }
/* 1342 */     return containsNone(str, invalidChars.toCharArray());
   }
 
   public static int indexOfAny(String str, String[] searchStrs)
   {
/* 1374 */     if ((str == null) || (searchStrs == null)) {
/* 1375 */       return -1;
     }
/* 1377 */     int sz = searchStrs.length;
 
/* 1380 */     int ret = 2147483647;
 
/* 1382 */     int tmp = 0;
/* 1383 */     for (int i = 0; i < sz; i++) {
/* 1384 */       String search = searchStrs[i];
/* 1385 */       if (search == null) {
         continue;
       }
/* 1388 */       tmp = str.indexOf(search);
/* 1389 */       if (tmp == -1)
       {
         continue;
       }
/* 1393 */       if (tmp < ret) {
/* 1394 */         ret = tmp;
       }
     }
 
/* 1398 */     return ret == 2147483647 ? -1 : ret;
   }
 
   public static int lastIndexOfAny(String str, String[] searchStrs)
   {
/* 1427 */     if ((str == null) || (searchStrs == null)) {
/* 1428 */       return -1;
     }
/* 1430 */     int sz = searchStrs.length;
/* 1431 */     int ret = -1;
/* 1432 */     int tmp = 0;
/* 1433 */     for (int i = 0; i < sz; i++) {
/* 1434 */       String search = searchStrs[i];
/* 1435 */       if (search == null) {
         continue;
       }
/* 1438 */       tmp = str.lastIndexOf(search);
/* 1439 */       if (tmp > ret) {
/* 1440 */         ret = tmp;
       }
     }
/* 1443 */     return ret;
   }
 
   public static String substring(String str, int start)
   {
/* 1473 */     if (str == null) {
/* 1474 */       return null;
     }
 
/* 1478 */     if (start < 0) {
/* 1479 */       start = str.length() + start;
     }
 
/* 1482 */     if (start < 0) {
/* 1483 */       start = 0;
     }
/* 1485 */     if (start > str.length()) {
/* 1486 */       return "";
     }
 
/* 1489 */     return str.substring(start);
   }
 
   public static String substring(String str, int start, int end)
   {
/* 1528 */     if (str == null) {
/* 1529 */       return null;
     }
 
/* 1533 */     if (end < 0) {
/* 1534 */       end = str.length() + end;
     }
/* 1536 */     if (start < 0) {
/* 1537 */       start = str.length() + start;
     }
 
/* 1541 */     if (end > str.length()) {
/* 1542 */       end = str.length();
     }
 
/* 1546 */     if (start > end) {
/* 1547 */       return "";
     }
 
/* 1550 */     if (start < 0) {
/* 1551 */       start = 0;
     }
/* 1553 */     if (end < 0) {
/* 1554 */       end = 0;
     }
 
/* 1557 */     return str.substring(start, end);
   }
 
   public static String left(String str, int len)
   {
/* 1583 */     if (str == null) {
/* 1584 */       return null;
     }
/* 1586 */     if (len < 0) {
/* 1587 */       return "";
     }
/* 1589 */     if (str.length() <= len) {
/* 1590 */       return str;
     }
/* 1592 */     return str.substring(0, len);
   }
 
   public static String right(String str, int len)
   {
/* 1617 */     if (str == null) {
/* 1618 */       return null;
     }
/* 1620 */     if (len < 0) {
/* 1621 */       return "";
     }
/* 1623 */     if (str.length() <= len) {
/* 1624 */       return str;
     }
/* 1626 */     return str.substring(str.length() - len);
   }
 
   public static String mid(String str, int pos, int len)
   {
/* 1655 */     if (str == null) {
/* 1656 */       return null;
     }
/* 1658 */     if ((len < 0) || (pos > str.length())) {
/* 1659 */       return "";
     }
/* 1661 */     if (pos < 0) {
/* 1662 */       pos = 0;
     }
/* 1664 */     if (str.length() <= pos + len) {
/* 1665 */       return str.substring(pos);
     }
/* 1667 */     return str.substring(pos, pos + len);
   }
 
   public static String substringBefore(String str, String separator)
   {
/* 1699 */     if ((isEmpty(str)) || (separator == null)) {
/* 1700 */       return str;
     }
/* 1702 */     if (separator.length() == 0) {
/* 1703 */       return "";
     }
/* 1705 */     int pos = str.indexOf(separator);
/* 1706 */     if (pos == -1) {
/* 1707 */       return str;
     }
/* 1709 */     return str.substring(0, pos);
   }
 
   public static String substringAfter(String str, String separator)
   {
/* 1739 */     if (isEmpty(str)) {
/* 1740 */       return str;
     }
/* 1742 */     if (separator == null) {
/* 1743 */       return "";
     }
/* 1745 */     int pos = str.indexOf(separator);
/* 1746 */     if (pos == -1) {
/* 1747 */       return "";
     }
/* 1749 */     return str.substring(pos + separator.length());
   }
 
   public static String substringBeforeLast(String str, String separator)
   {
/* 1778 */     if ((isEmpty(str)) || (isEmpty(separator))) {
/* 1779 */       return str;
     }
/* 1781 */     int pos = str.lastIndexOf(separator);
/* 1782 */     if (pos == -1) {
/* 1783 */       return str;
     }
/* 1785 */     return str.substring(0, pos);
   }
 
   public static String substringAfterLast(String str, String separator)
   {
/* 1816 */     if (isEmpty(str)) {
/* 1817 */       return str;
     }
/* 1819 */     if (isEmpty(separator)) {
/* 1820 */       return "";
     }
/* 1822 */     int pos = str.lastIndexOf(separator);
/* 1823 */     if ((pos == -1) || (pos == str.length() - separator.length())) {
/* 1824 */       return "";
     }
/* 1826 */     return str.substring(pos + separator.length());
   }
 
   public static String substringBetween(String str, String tag)
   {
/* 1853 */     return substringBetween(str, tag, tag);
   }
 
   public static String substringBetween(String str, String open, String close)
   {
/* 1884 */     if ((str == null) || (open == null) || (close == null)) {
/* 1885 */       return null;
     }
/* 1887 */     int start = str.indexOf(open);
/* 1888 */     if (start != -1) {
/* 1889 */       int end = str.indexOf(close, start + open.length());
/* 1890 */       if (end != -1) {
/* 1891 */         return str.substring(start + open.length(), end);
       }
     }
/* 1894 */     return null;
   }
 

 
   /** @deprecated */
   public static String getNestedString(String str, String tag)
   {
/* 1976 */     return substringBetween(str, tag, tag);
   }
 
   /** @deprecated */
   public static String getNestedString(String str, String open, String close)
   {
/* 2006 */     return substringBetween(str, open, close);
   }
 
   /** @deprecated */
   public static String concatenate(Object[] array)
   {
/* 2554 */     return join(array, null);
   }
 
   public static String join(Object[] array)
   {
/* 2578 */     return join(array, null);
   }
 
   public static String join(Object[] array, char separator)
   {
/* 2604 */     if (array == null) {
/* 2605 */       return null;
     }
 
/* 2608 */     return join(array, separator, 0, array.length);
   }
 
   public static String join(Object[] array, char separator, int startIndex, int endIndex)
   {
/* 2638 */     if (array == null) {
/* 2639 */       return null;
     }
/* 2641 */     int bufSize = endIndex - startIndex;
/* 2642 */     if (bufSize <= 0) {
/* 2643 */       return "";
     }
 
/* 2646 */     bufSize *= ((array[startIndex] == null ? 16 : array[startIndex].toString().length()) + 1);
/* 2647 */     StringBuffer buf = new StringBuffer(bufSize);
 
/* 2649 */     for (int i = startIndex; i < endIndex; i++) {
/* 2650 */       if (i > startIndex) {
/* 2651 */         buf.append(separator);
       }
/* 2653 */       if (array[i] != null) {
/* 2654 */         buf.append(array[i]);
       }
     }
/* 2657 */     return buf.toString();
   }
 
   public static String join(Object[] array, String separator)
   {
/* 2685 */     if (array == null) {
/* 2686 */       return null;
     }
/* 2688 */     return join(array, separator, 0, array.length);
   }
 
   public static String join(Object[] array, String separator, int startIndex, int endIndex)
   {
/* 2719 */     if (array == null) {
/* 2720 */       return null;
     }
/* 2722 */     if (separator == null) {
/* 2723 */       separator = "";
     }
 
/* 2728 */     int bufSize = endIndex - startIndex;
/* 2729 */     if (bufSize <= 0) {
/* 2730 */       return "";
     }
 
/* 2733 */     bufSize *= ((array[startIndex] == null ? 16 : array[startIndex].toString().length()) + separator.length());
 
/* 2736 */     StringBuffer buf = new StringBuffer(bufSize);
 
/* 2738 */     for (int i = startIndex; i < endIndex; i++) {
/* 2739 */       if (i > startIndex) {
/* 2740 */         buf.append(separator);
       }
/* 2742 */       if (array[i] != null) {
/* 2743 */         buf.append(array[i]);
       }
     }
/* 2746 */     return buf.toString();
   }

   private static String padding(int repeat, char padChar)
     throws IndexOutOfBoundsException
   {
/* 3752 */     if (repeat < 0) {
/* 3753 */       throw new IndexOutOfBoundsException("Cannot pad a negative amount: " + repeat);
     }
/* 3755 */     char[] buf = new char[repeat];
/* 3756 */     for (int i = 0; i < buf.length; i++) {
/* 3757 */       buf[i] = padChar;
     }
/* 3759 */     return new String(buf);
   }
 
   public static String rightPad(String str, int size)
   {
/* 3782 */     return rightPad(str, size, ' ');
   }
 
   public static String rightPad(String str, int size, char padChar)
   {
/* 3807 */     if (str == null) {
/* 3808 */       return null;
     }
/* 3810 */     int pads = size - str.length();
/* 3811 */     if (pads <= 0) {
/* 3812 */       return str;
     }
/* 3814 */     if (pads > 8192) {
/* 3815 */       return rightPad(str, size, String.valueOf(padChar));
     }
/* 3817 */     return str.concat(padding(pads, padChar));
   }
 
   public static String rightPad(String str, int size, String padStr)
   {
/* 3844 */     if (str == null) {
/* 3845 */       return null;
     }
/* 3847 */     if (isEmpty(padStr)) {
/* 3848 */       padStr = " ";
     }
/* 3850 */     int padLen = padStr.length();
/* 3851 */     int strLen = str.length();
/* 3852 */     int pads = size - strLen;
/* 3853 */     if (pads <= 0) {
/* 3854 */       return str;
     }
/* 3856 */     if ((padLen == 1) && (pads <= 8192)) {
/* 3857 */       return rightPad(str, size, padStr.charAt(0));
     }
 
/* 3860 */     if (pads == padLen)
/* 3861 */       return str.concat(padStr);
/* 3862 */     if (pads < padLen) {
/* 3863 */       return str.concat(padStr.substring(0, pads));
     }
/* 3865 */     char[] padding = new char[pads];
/* 3866 */     char[] padChars = padStr.toCharArray();
/* 3867 */     for (int i = 0; i < pads; i++) {
/* 3868 */       padding[i] = padChars[(i % padLen)];
     }
/* 3870 */     return str.concat(new String(padding));
   }
 
   public static String leftPad(String str, int size)
   {
/* 3894 */     return leftPad(str, size, ' ');
   }
 
   public static String leftPad(String str, int size, char padChar)
   {
/* 3919 */     if (str == null) {
/* 3920 */       return null;
     }
/* 3922 */     int pads = size - str.length();
/* 3923 */     if (pads <= 0) {
/* 3924 */       return str;
     }
/* 3926 */     if (pads > 8192) {
/* 3927 */       return leftPad(str, size, String.valueOf(padChar));
     }
/* 3929 */     return padding(pads, padChar).concat(str);
   }
 
   public static String leftPad(String str, int size, String padStr)
   {
/* 3956 */     if (str == null) {
/* 3957 */       return null;
     }
/* 3959 */     if (isEmpty(padStr)) {
/* 3960 */       padStr = " ";
     }
/* 3962 */     int padLen = padStr.length();
/* 3963 */     int strLen = str.length();
/* 3964 */     int pads = size - strLen;
/* 3965 */     if (pads <= 0) {
/* 3966 */       return str;
     }
/* 3968 */     if ((padLen == 1) && (pads <= 8192)) {
/* 3969 */       return leftPad(str, size, padStr.charAt(0));
     }
 
/* 3972 */     if (pads == padLen)
/* 3973 */       return padStr.concat(str);
/* 3974 */     if (pads < padLen) {
/* 3975 */       return padStr.substring(0, pads).concat(str);
     }
/* 3977 */     char[] padding = new char[pads];
/* 3978 */     char[] padChars = padStr.toCharArray();
/* 3979 */     for (int i = 0; i < pads; i++) {
/* 3980 */       padding[i] = padChars[(i % padLen)];
     }
/* 3982 */     return new String(padding).concat(str);
   }
 
   public static String center(String str, int size)
   {
/* 4012 */     return center(str, size, ' ');
   }
 
   public static String center(String str, int size, char padChar)
   {
/* 4040 */     if ((str == null) || (size <= 0)) {
/* 4041 */       return str;
     }
/* 4043 */     int strLen = str.length();
/* 4044 */     int pads = size - strLen;
/* 4045 */     if (pads <= 0) {
/* 4046 */       return str;
     }
/* 4048 */     str = leftPad(str, strLen + pads / 2, padChar);
/* 4049 */     str = rightPad(str, size, padChar);
/* 4050 */     return str;
   }
 
   public static String center(String str, int size, String padStr)
   {
/* 4080 */     if ((str == null) || (size <= 0)) {
/* 4081 */       return str;
     }
/* 4083 */     if (isEmpty(padStr)) {
/* 4084 */       padStr = " ";
     }
/* 4086 */     int strLen = str.length();
/* 4087 */     int pads = size - strLen;
/* 4088 */     if (pads <= 0) {
/* 4089 */       return str;
     }
/* 4091 */     str = leftPad(str, strLen + pads / 2, padStr);
/* 4092 */     str = rightPad(str, size, padStr);
/* 4093 */     return str;
   }
 
   public static String upperCase(String str)
   {
/* 4113 */     if (str == null) {
/* 4114 */       return null;
     }
/* 4116 */     return str.toUpperCase();
   }
 
   public static String lowerCase(String str)
   {
/* 4134 */     if (str == null) {
/* 4135 */       return null;
     }
/* 4137 */     return str.toLowerCase();
   }
 
   public static String capitalize(String str)
   {
     int strLen;
/* 4162 */     if ((str == null) || ((strLen = str.length()) == 0)) {
/* 4163 */       return str;
     }
/* 4165 */     return strLen + Character.toTitleCase(str.charAt(0)) + str.substring(1);
   }
 
   /** @deprecated */
   public static String capitalise(String str)
   {
/* 4181 */     return capitalize(str);
   }
 
   public static String uncapitalize(String str)
   {
     int strLen;
/* 4206 */     if ((str == null) || ((strLen = str.length()) == 0)) {
/* 4207 */       return str;
     }
/* 4209 */     return strLen + Character.toLowerCase(str.charAt(0)) + str.substring(1);
   }
 
   /** @deprecated */
   public static String uncapitalise(String str)
   {
/* 4225 */     return uncapitalize(str);
   }
 
   public static String swapCase(String str)
   {
     int strLen;
/* 4257 */     if ((str == null) || ((strLen = str.length()) == 0)) {
/* 4258 */       return str;
     }
/* 4260 */     StringBuffer buffer = new StringBuffer(strLen);
 
/* 4262 */     char ch = '\000';
/* 4263 */     for (int i = 0; i < strLen; i++) {
/* 4264 */       ch = str.charAt(i);
/* 4265 */       if (Character.isUpperCase(ch))
/* 4266 */         ch = Character.toLowerCase(ch);
/* 4267 */       else if (Character.isTitleCase(ch))
/* 4268 */         ch = Character.toLowerCase(ch);
/* 4269 */       else if (Character.isLowerCase(ch)) {
/* 4270 */         ch = Character.toUpperCase(ch);
       }
/* 4272 */       buffer.append(ch);
     }
/* 4274 */     return buffer.toString();
   }
 

 
   public static int countMatches(String str, String sub)
   {
/* 4315 */     if ((isEmpty(str)) || (isEmpty(sub))) {
/* 4316 */       return 0;
     }
/* 4318 */     int count = 0;
/* 4319 */     int idx = 0;
/* 4320 */     while ((idx = str.indexOf(sub, idx)) != -1) {
/* 4321 */       count++;
/* 4322 */       idx += sub.length();
     }
/* 4324 */     return count;
   }
 
   public static boolean isAlpha(String str)
   {
/* 4348 */     if (str == null) {
/* 4349 */       return false;
     }
/* 4351 */     int sz = str.length();
/* 4352 */     for (int i = 0; i < sz; i++) {
/* 4353 */       if (!Character.isLetter(str.charAt(i))) {
/* 4354 */         return false;
       }
     }
/* 4357 */     return true;
   }
 
   public static boolean isAlphaSpace(String str)
   {
/* 4382 */     if (str == null) {
/* 4383 */       return false;
     }
/* 4385 */     int sz = str.length();
/* 4386 */     for (int i = 0; i < sz; i++) {
/* 4387 */       if ((!Character.isLetter(str.charAt(i))) && (str.charAt(i) != ' ')) {
/* 4388 */         return false;
       }
     }
/* 4391 */     return true;
   }
 
   public static boolean isAlphanumeric(String str)
   {
/* 4415 */     if (str == null) {
/* 4416 */       return false;
     }
/* 4418 */     int sz = str.length();
/* 4419 */     for (int i = 0; i < sz; i++) {
/* 4420 */       if (!Character.isLetterOrDigit(str.charAt(i))) {
/* 4421 */         return false;
       }
     }
/* 4424 */     return true;
   }
 
   public static boolean isAlphanumericSpace(String str)
   {
/* 4449 */     if (str == null) {
/* 4450 */       return false;
     }
/* 4452 */     int sz = str.length();
/* 4453 */     for (int i = 0; i < sz; i++) {
/* 4454 */       if ((!Character.isLetterOrDigit(str.charAt(i))) && (str.charAt(i) != ' ')) {
/* 4455 */         return false;
       }
     }
/* 4458 */     return true;
   }

   public static boolean isNumeric(String str)
   {
/* 4521 */     if (str == null) {
/* 4522 */       return false;
     }
/* 4524 */     int sz = str.length();
/* 4525 */     for (int i = 0; i < sz; i++) {
/* 4526 */       if (!Character.isDigit(str.charAt(i))) {
/* 4527 */         return false;
       }
     }
/* 4530 */     return true;
   }
 
   public static boolean isNumericSpace(String str)
   {
/* 4557 */     if (str == null) {
/* 4558 */       return false;
     }
/* 4560 */     int sz = str.length();
/* 4561 */     for (int i = 0; i < sz; i++) {
/* 4562 */       if ((!Character.isDigit(str.charAt(i))) && (str.charAt(i) != ' ')) {
/* 4563 */         return false;
       }
     }
/* 4566 */     return true;
   }
 
   public static boolean isWhitespace(String str)
   {
/* 4589 */     if (str == null) {
/* 4590 */       return false;
     }
/* 4592 */     int sz = str.length();
/* 4593 */     for (int i = 0; i < sz; i++) {
/* 4594 */       if (!Character.isWhitespace(str.charAt(i))) {
/* 4595 */         return false;
       }
     }
/* 4598 */     return true;
   }
 
   public static String defaultString(String str)
   {
/* 4620 */     return str == null ? "" : str;
   }
 
   public static String defaultString(String str, String defaultStr)
   {
/* 4641 */     return str == null ? defaultStr : str;
   }
 
   public static String defaultIfEmpty(String str, String defaultStr)
   {
     return isEmpty(str) ? defaultStr : str;
   }
 
   public static String reverse(String str)
   {
     if (str == null) {
       return null;
     }
     return new StringBuffer(str).reverse().toString();
   }
   
   public static String mime(String nombImagen) {
		String mime=null;
		int extDot = nombImagen.lastIndexOf('.');
		if(extDot > 0){
			String extension = nombImagen.substring(extDot +1);
			if("bmp".equals(extension)){
				mime="image/bmp";
			} else if("jpg".equals(extension)){
				mime="image/jpeg";
			} else if("gif".equals(extension)){
				mime="image/gif";
			} else if("png".equals(extension)){
				mime="image/png";
			} else if("ico".equals(extension)){
				mime="image/ico";	
			} else {
				mime = "image/unknown";
			}
		}
		return mime;
	}
   
   public static String generaClaveTemporal(){
		String clave=null;
		try {
			char[] elementos={'0','1','2','3','4','5','6','7','8','9' ,'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
			char[] conjunto = new char[8];
			for(int i=0;i<conjunto.length;i++){
				int el = (int)(Math.random()*elementos.length);
				conjunto[i] = (char)elementos[el];
			}
			clave = new String(conjunto);
			
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return clave;
	}
}




