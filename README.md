# kotlin_filter_sort_reduce_map


#Company (name,type,startYear,endYear)

#List of Companies (10 Companies)
* 1.Company("C1", "Technology", startYear = 1995, endYear = null)
* 2.Company("C2", "Finance", startYear = 1994, endYear = 2011)
* 3.Company("C3", "Industry", startYear = 1993, endYear = 2020)
* 4.Company("C4", "Auto", startYear = 2001, endYear = 2021)
* 5.Company("C5", "Hotel", startYear = 2001, endYear = 2020)
* 6.Company("C6", "Technology", startYear = 2005, endYear = 2015)
* 7.Company("C7", "Finance", startYear = 1996, endYear = 2014)
* 8.Company("C8", "Finance", startYear = 1980, endYear = 2007)
* 9.Company("C9", "Auto", startYear = 1985, endYear = 2008)
* 10.Company("C10", "Hotel", startYear = 1989, endYear = 2004)

#Questions
* 1.Get the List of Technology Companies.
* 2.Get the List of Companies, which started after 1994 (i.e >1994)
* 3.Get  the List of Companies by their Type in Ascending Order.
* 4.Get the List of Companies by their End year in Descending Order
* 5.Get the List with only the name of the Company
* 6.Get a list with only the name and age of the Company.
* 7.Print the data in following format : Company Name -> [startDate - endDate]
* 8.Get the total years for all companies i.e sum of age of all companies


#OUTPUT

```
Use of Higher Orders Functions Like Filter Sort Map and Reduce in Kotlin to Manipulate List
------------------------------- printListUsingForLoop ---------------------------
Company(name=C1, type=Technology, startYear=1995, endYear=null)
Company(name=C2, type=Finance, startYear=1994, endYear=2011)
Company(name=C3, type=Industry, startYear=1993, endYear=2020)
Company(name=C4, type=Auto, startYear=2001, endYear=2021)
Company(name=C5, type=Hotel, startYear=2001, endYear=2020)
Company(name=C6, type=Technology, startYear=2005, endYear=2015)
Company(name=C7, type=Finance, startYear=1996, endYear=2014)
Company(name=C8, type=Finance, startYear=1980, endYear=2007)
Company(name=C9, type=Auto, startYear=1985, endYear=2008)
Company(name=C10, type=Hotel, startYear=1989, endYear=2004)

------------------------------- printListUsingForEachLoop ---------------------------
Company(name=C1, type=Technology, startYear=1995, endYear=null)
Company(name=C2, type=Finance, startYear=1994, endYear=2011)
Company(name=C3, type=Industry, startYear=1993, endYear=2020)
Company(name=C4, type=Auto, startYear=2001, endYear=2021)
Company(name=C5, type=Hotel, startYear=2001, endYear=2020)
Company(name=C6, type=Technology, startYear=2005, endYear=2015)
Company(name=C7, type=Finance, startYear=1996, endYear=2014)
Company(name=C8, type=Finance, startYear=1980, endYear=2007)
Company(name=C9, type=Auto, startYear=1985, endYear=2008)
Company(name=C10, type=Hotel, startYear=1989, endYear=2004)

------------------------------- Q1. Get the List of Technology Companies. ---------------------------
Company(name=C1, type=Technology, startYear=1995, endYear=null)
Company(name=C6, type=Technology, startYear=2005, endYear=2015)

------------------------------- Q2. Get the List of Companies, which started after 1994 (i.e >1994) ---------------------------
Company(name=C1, type=Technology, startYear=1995, endYear=null)
Company(name=C4, type=Auto, startYear=2001, endYear=2021)
Company(name=C5, type=Hotel, startYear=2001, endYear=2020)
Company(name=C6, type=Technology, startYear=2005, endYear=2015)
Company(name=C7, type=Finance, startYear=1996, endYear=2014)

------------------------------- Q1. Get the List of Technology Companies. ---------------------------
Company(name=C1, type=Technology, startYear=1995, endYear=null)
Company(name=C6, type=Technology, startYear=2005, endYear=2015)

------------------------------- Q2. Get the List of Companies, which started after 1994 (i.e >1994)---------------------------
Company(name=C1, type=Technology, startYear=1995, endYear=null)
Company(name=C4, type=Auto, startYear=2001, endYear=2021)
Company(name=C5, type=Hotel, startYear=2001, endYear=2020)
Company(name=C6, type=Technology, startYear=2005, endYear=2015)
Company(name=C7, type=Finance, startYear=1996, endYear=2014)

------------------------------- Q3. Get  the List of Companies by their Type in Ascending Order. ---------------------------
Company(name=C4, type=Auto, startYear=2001, endYear=2021)
Company(name=C9, type=Auto, startYear=1985, endYear=2008)
Company(name=C2, type=Finance, startYear=1994, endYear=2011)
Company(name=C7, type=Finance, startYear=1996, endYear=2014)
Company(name=C8, type=Finance, startYear=1980, endYear=2007)
Company(name=C5, type=Hotel, startYear=2001, endYear=2020)
Company(name=C10, type=Hotel, startYear=1989, endYear=2004)
Company(name=C3, type=Industry, startYear=1993, endYear=2020)
Company(name=C1, type=Technology, startYear=1995, endYear=null)
Company(name=C6, type=Technology, startYear=2005, endYear=2015)

------------------------------- Q4. Get the List of Companies by their End year in Descending Order ---------------------------
Company(name=C4, type=Auto, startYear=2001, endYear=2021)
Company(name=C3, type=Industry, startYear=1993, endYear=2020)
Company(name=C5, type=Hotel, startYear=2001, endYear=2020)
Company(name=C6, type=Technology, startYear=2005, endYear=2015)
Company(name=C7, type=Finance, startYear=1996, endYear=2014)
Company(name=C2, type=Finance, startYear=1994, endYear=2011)
Company(name=C9, type=Auto, startYear=1985, endYear=2008)
Company(name=C8, type=Finance, startYear=1980, endYear=2007)
Company(name=C10, type=Hotel, startYear=1989, endYear=2004)
Company(name=C1, type=Technology, startYear=1995, endYear=null)

------------------------------- Q5. Get the List with only the name of the Company ---------------------------
C1
C2
C3
C4
C5
C6
C7
C8
C9
C10

------------------------------- Q6. Get a list with only the name and age of the Company ---------------------------
C1 -> 26
C2 -> 17
C3 -> 27
C4 -> 20
C5 -> 19
C6 -> 10
C7 -> 18
C8 -> 27
C9 -> 23
C10 -> 15

------------------------------- Q7. Print the data in following format : Company Name -> [startDate - endDate]  ---------------------------
C1 -> [1995 - null]
C2 -> [1994 - 2011]
C3 -> [1993 - 2020]
C4 -> [2001 - 2021]
C5 -> [2001 - 2020]
C6 -> [2005 - 2015]
C7 -> [1996 - 2014]
C8 -> [1980 - 2007]
C9 -> [1985 - 2008]
C10 -> [1989 - 2004]

------------------------------- Q8. Get the total years for all companies i.e sum of age of all companies ---------------------------
202
------------------------------- Q9. Get the sum of Start  Year for all companies. ---------------------------
19939
------------------------------- Q10. Get the list of companies after 1994 sorted by start year ---------------------------
Company(name=C1, type=Technology, startYear=1995, endYear=null)
Company(name=C7, type=Finance, startYear=1996, endYear=2014)
Company(name=C4, type=Auto, startYear=2001, endYear=2021)
Company(name=C5, type=Hotel, startYear=2001, endYear=2020)
Company(name=C6, type=Technology, startYear=2005, endYear=2015)

------------------------------- Q11. Get the sum of start year of companies started after 1994 ---------------------------
9998

```
