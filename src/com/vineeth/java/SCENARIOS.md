**MYSQL Database:**
---------------------------------------------------------------------------------
1. What is the difference between INNER JOIN, LEFT JOIN, RIGHT JOIN?
	1. **INNER JOIN** → Returns only matching rows from both tables  
	2. **LEFT JOIN** → Returns all rows from the left table + matching rows from the right table (NULL 	if 	no 	match)  
	3. **RIGHT JOIN** → Returns all rows from the right table + matching rows from the left table (NULL if no 	match)  
2. Difference between WHERE vs HAVING

- **WHERE** → Filters rows *before* grouping (used with SELECT)  
- **HAVING** → Filters groups *after* `GROUP BY` is applied  