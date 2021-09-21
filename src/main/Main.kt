package main

import main.Company

lateinit var companyList: MutableList<Company>

/**
 * QUESTIONS
 *  1. Get the List of Technology Companies.
 *  2. Get the List of Companies, which started after 1994 (i.e >1994)
 *  3. Get  the List of Companies by their Type in Ascending Order.
 *  4. Get the List of Companies by their End year in Descending Order
 *  5. Get the List with only the name of the Company
 *  6. Get a list with only the name and age of the Company.
 *  7. Print the data in following format : Company Name -> [startDate - endDate]
 *  8. Get the total years for all companies i.e sum of age of all companies
 */
fun main(args: Array<String>) {
    println("Use of Higher Orders Functions Like Filter Sort Map and Reduce in Kotlin to Manipulate List")

    companyList = mutableListOf()

    companyList.add(Company("C1", "Technology", startYear = 1995, endYear = null))
    companyList.add(Company("C2", "Finance", startYear = 1994, endYear = 2011))
    companyList.add(Company("C3", "Industry", startYear = 1993, endYear = 2020))
    companyList.add(Company("C4", "Auto", startYear = 2001, endYear = 2021))
    companyList.add(Company("C5", "Hotel", startYear = 2001, endYear = 2020))
    companyList.add(Company("C6", "Technology", startYear = 2005, endYear = 2015))
    companyList.add(Company("C7", "Finance", startYear = 1996, endYear = 2014))
    companyList.add(Company("C8", "Finance", startYear = 1980, endYear = 2007))
    companyList.add(Company("C9", "Auto", startYear = 1985, endYear = 2008))
    companyList.add(Company("C10", "Hotel", startYear = 1989, endYear = 2004))

    /**
     * Use of Two Different Approaches to Print List
     */
    // print Company List using For Loop
    println("------------------------------- printListUsingForLoop ---------------------------")
    printListUsingForLoop(companyList.toMutableList())

    // print Company List using ForEach Loop
    println("------------------------------- printListUsingForEachLoop ---------------------------")
    printListUsingForEachLoop(companyList.toMutableList())

    /**
     * Filter :
     *  - GIVES a list of data based on a criteria
     *  - the size of filteredList may or may not be equal to the original list.
     */
    // Filter Using Loop
    filterUsingLoop(companyList)

    // Filter Using Filter Predicate
    filterUsingFilterPredicate(companyList)

    /**
     * Sort :
     *  - ORDERS the data based on a criteria
     *  - the size of sortedList is always equal to original list
     */
    sortUsingSortPredicate(companyList)

    /**
     * Map:
     *  - Creates a new List with required Attributes from original list based on a criteria
     */
    mapUsingMapPredicate(companyList)

    /**
     * Reduce :
     *  -
     */
    reduceUsingReducePredicate(companyList)
}

fun printListUsingForLoop(list: MutableList<Any>) {

    for (i in 0 until list.size) {
        println(list[i])
    }
    print("\n")
}

fun printListUsingForEachLoop(list: MutableList<Any>) {

    /**
     * Approach :
     * This approach is Passing One Function inside Another Function(i.e Higher Order Function in Kotlin) (called as Lambda Function)
     * lambda functions are not declared but are passed immediately as an expression, So everything inside the {} is
     * function definition, and this function will be called by the parent function (Note the params of Lambda Function are already defined by parent function)
     *
     * Usage:
     *  It can be used for writing more Readable and Concise code
     */
    list.forEach {
        println(it)
    }

    print("\n")
}

fun filterUsingLoop(companyList: MutableList<Company>) {

    /**
     * Q1. Get the List of Technology Companies.
     */
    val technologyCompanyList = mutableListOf<Company>()

    // Add the filtered data to New List
    companyList.forEach { company ->
        if (company.type == "Technology")
            technologyCompanyList.add(company)
    }

    // print the list
    println("------------------------------- Get the List of Technology Companies. ---------------------------")
    printListUsingForEachLoop(technologyCompanyList.toMutableList())

    /**
     * Q2. Get the List of Companies, which started after 1994 (i.e >1994)
     */
    val companyAfter1994List = mutableListOf<Company>()

    // Add the filtered data to New List
    companyList.forEach { company ->
        if (company.startYear > 1994)
            companyAfter1994List.add(company)
    }

    // print the list
    println("------------------------------- Get the List of Companies, which started after 1994 (i.e >1994) ---------------------------")
    printListUsingForEachLoop(companyAfter1994List.toMutableList())

}

fun filterUsingFilterPredicate(companyList: MutableList<Company>) {
    /**
     * Q1. Get the List of Technology Companies.
     */
    val technologyCompanyList = companyList.filter { company ->
        company.type == "Technology"
    }
    // print the list
    println("------------------------------- Get the List of Technology Companies. ---------------------------")
    printListUsingForEachLoop(technologyCompanyList.toMutableList())

    /**
     * Q2. Get the List of Companies, which started after 1994 (i.e >1994)
     */
    // Add the filtered data to New List
    val companyAfter1994List = companyList.filter { company ->
        company.startYear > 1994
    }

    // print the list
    println("------------------------------- Get the List of Companies, which started after 1994 (i.e >1994)---------------------------")
    printListUsingForEachLoop(companyAfter1994List.toMutableList())
}

fun sortUsingSortPredicate(companyList: MutableList<Company>) {

    /**
     * Q3. Get  the List of Companies by their Type in Ascending Order.
     */
    val sortedCompanyListByType = companyList.sortedBy {
        it.type
    }
    println("------------------------------- Get  the List of Companies by their Type in Ascending Order. ---------------------------")
    printListUsingForEachLoop((sortedCompanyListByType.toMutableList()))

    /**
     * Q4. Get the List of Companies by their End year in Descending Order
     */
    val sortedCompanyListByEndYear = companyList.sortedByDescending {
        it.endYear
    }
    println("------------------------------- Get the List of Companies by their End year in Descending Order ---------------------------")
    printListUsingForEachLoop(sortedCompanyListByEndYear.toMutableList())
}

fun mapUsingMapPredicate(companyList: MutableList<Company>) {

    /**
     * Q5. Get the List with only the name of the Company
     */
    val companyNameList: List<String> = companyList.map {
        it.name
    }
    println("------------------------------- Get the List with only the name of the Company ---------------------------")
    printListUsingForEachLoop(companyNameList.toMutableList())

    /**
     * Q6. Get a list with only the name and age of the Company
     */
    val companyNameAndAgeList: List<String> = companyList.map {
        if (it.endYear == null) {
            var age = 2021 - it.startYear
            "${it.name} -> $age"
        } else {
            var age = it.endYear - it.startYear
            "${it.name} -> $age"
        }


    }
    println("------------------------------- Get a list with only the name and age of the Company ---------------------------")
    printListUsingForEachLoop(companyNameAndAgeList.toMutableList())

    /**
     *Q7. Print the data in following format : Company Name -> [startDate - endDate]
     */
    val companyNameWithDatesList: List<String> = companyList.map {
        "${it.name} -> [${it.startYear} - ${it.endYear}]"
    }
    println("------------------------------- Print the data in following format : Company Name -> [startDate - endDate]  ---------------------------")
    printListUsingForEachLoop(companyNameWithDatesList.toMutableList())

}

fun reduceUsingReducePredicate(companyList: MutableList<Company>) {
    /**
     * Q8. Get the total years for all companies i.e sum of age of all companies
     */
    val sumOfAge = companyList.sumBy {
        if (it.endYear == null) {
            2021 - it.startYear
        } else {
            it.endYear - it.startYear

        }
    }
    println("------------------------------- Get the total years for all companies i.e sum of age of all companies ---------------------------")
    println(sumOfAge)

    /**
     * Q9. Get the sum of Start  Year for all companies.
     */
    val sumOfStartYear = companyList.map {
        it.startYear
    }.reduce { acc, i ->
        acc + i
    }

    println("------------------------------- Get the sum of Start  Year for all companies. ---------------------------")
    println(sumOfStartYear)

}
