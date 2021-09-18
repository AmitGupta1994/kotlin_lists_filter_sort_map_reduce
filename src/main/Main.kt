package main


lateinit var companyList: MutableList<Company>

fun main(args: Array<String>) {
    println("Filter Sort Map Reduce in Kotlin")

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

    // print Company List using For Loop
    println("------------------------------- printListUsingForLoop ---------------------------")
    printListUsingForLoop(companyList.toMutableList())

    // print Company List using For Each Loop
    println("------------------------------- printListUsingForEachLoop ---------------------------")
    printListUsingForEachLoop(companyList.toMutableList())

    /**
     * Filter :
     *  - gives a list of data based on a criteria
     *  - the size of filteredList may or may not be equal to the original list.
     */
    // Filter Using Loop
    filterUsingLoop(companyList)

    // Filter Using Filter Predicate
    filterUsingFilterPredicate(companyList)

    /**
     * Sort :
     *  - orders the data based on a criteria
     *  - the size of sortedList is always equal to original list
     */
    sortUsingSortPredicate(companyList)

    /**
     * Map:
     *  - Create a new List from original list based on a criteria
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
    // Q1. Filter List of Technology Companies
    val technologyCompanyList = mutableListOf<Company>()

    // Add the filtered data to New List
    companyList.forEach { company ->
        if (company.type == "Technology")
            technologyCompanyList.add(company)
    }

    // print the list
    println("------------------------------- Filter Technology Company List Using Loop ---------------------------")
    printListUsingForEachLoop(technologyCompanyList.toMutableList())

    // Q2. Filter List of Companies, which started after 1994 (i.e >1994)
    val companyAfter1994List = mutableListOf<Company>()

    // Add the filtered data to New List
    companyList.forEach { company ->
        if (company.startYear != null && company.startYear > 1994)
            companyAfter1994List.add(company)
    }

    // print the list
    println("------------------------------- Filter Company List After 1994 Using Loop ---------------------------")
    printListUsingForEachLoop(companyAfter1994List.toMutableList())

}

fun filterUsingFilterPredicate(companyList: MutableList<Company>) {
    // Q1. Filter List of Technology Companies
    val technologyCompanyList = companyList.filter { company ->
        company.type == "Technology"
    }
    // print the list
    println("------------------------------- Filter Technology Company List Filter Predicate ---------------------------")
    printListUsingForEachLoop(technologyCompanyList.toMutableList())

    // Q2. Filter List of Companies, which started after 1994 (i.e >1994)
    // Add the filtered data to New List
    val companyAfter1994List = companyList.filter { company ->
        if (company.startYear != null)
            company.startYear > 1994
        else
            false
    }

    // print the list
    println("------------------------------- Filter Company List After 1994 Using Filter Predicate ---------------------------")
    printListUsingForEachLoop(companyAfter1994List.toMutableList())
}

fun sortUsingSortPredicate(companyList: MutableList<Company>) {
    // 1. Sort the Companies by their Type
    val sortedCompanyListByType = companyList.sortedBy {
        it.type
    }
    println("------------------------------- Sort By Company Type ---------------------------")
    printListUsingForEachLoop((sortedCompanyListByType.toMutableList()))

    // 2. Sort the Companies by their End year
    val sortedCompanyListByEndYear = companyList.sortedBy {
        it.endYear
    }
    println("------------------------------- Sort By Company End year ---------------------------")
    printListUsingForEachLoop(sortedCompanyListByEndYear.toMutableList())
}

fun mapUsingMapPredicate(companyList: MutableList<Company>) {
    // Get a list with only the name of Company.
    val companyNameList: List<String> = companyList.map {
        it.name
    }
    println("------------------------------- List of Company With Only its Name ---------------------------")
    printListUsingForEachLoop(companyNameList.toMutableList())

    // Get a list with only the name  and age of Company.
    val companyNameAndAgeList: List<String> = companyList.map {
        if (it.endYear == null) {
            var age = 2021 - it.startYear
            "${it.name} -> $age"
        } else {
            var age = it.endYear - it.startYear
            "${it.name} -> $age"
        }


    }
    println("------------------------------- List of Company With its Name and Age ---------------------------")
    printListUsingForEachLoop(companyNameAndAgeList.toMutableList())

    // Print the data in following format : Company Name -> [startDate - endDate]
    val companyNameWithDatesList: List<String> = companyList.map {
        "${it.name} -> [${it.startYear} - ${it.endYear}]"
    }
    println("------------------------------- Company Name -> [startDate - endDate] ---------------------------")
    printListUsingForEachLoop(companyNameWithDatesList.toMutableList())

}

fun reduceUsingReducePredicate(companyList: MutableList<Company>) {
    //1. total years for all companies i.e sum of age of all companies
    val sum = companyList.sumBy {
        if (it.endYear == null) {
            2021 - it.startYear
        } else {
            it.endYear - it.startYear

        }
    }

    println("------------------------------- total years for all companies i.e sum of age of all companies ---------------------------")
    println(sum)
}
