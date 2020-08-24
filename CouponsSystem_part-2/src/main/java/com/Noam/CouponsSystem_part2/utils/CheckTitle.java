package com.Noam.CouponsSystem_part2.utils;

import java.util.List;
import java.util.Optional;

import com.Noam.CouponsSystem_part2.beans.Company;
import com.Noam.CouponsSystem_part2.beans.Coupon;
import com.Noam.CouponsSystem_part2.beans.Customer;

public class CheckTitle {

	public static void startTest() {
		String str = " ######   #######  ##     ## ########   #######  ##    ##  ######     ########  ########   #######        ## ########  ######  ######## \r\n"
				+ "##    ## ##     ## ##     ## ##     ## ##     ## ###   ## ##    ##    ##     ## ##     ## ##     ##       ## ##       ##    ##    ##    \r\n"
				+ "##       ##     ## ##     ## ##     ## ##     ## ####  ## ##          ##     ## ##     ## ##     ##       ## ##       ##          ##    \r\n"
				+ "##       ##     ## ##     ## ########  ##     ## ## ## ##  ######     ########  ########  ##     ##       ## ######   ##          ##    \r\n"
				+ "##       ##     ## ##     ## ##        ##     ## ##  ####       ##    ##        ##   ##   ##     ## ##    ## ##       ##          ##    \r\n"
				+ "##    ## ##     ## ##     ## ##        ##     ## ##   ### ##    ##    ##        ##    ##  ##     ## ##    ## ##       ##    ##    ##    \r\n"
				+ " ######   #######   #######  ##         #######  ##    ##  ######     ##        ##     ##  #######   ######  ########  ######     ##   ";

		System.out.println(str);
	}

	public static void companiesServicecheck() {

		String str = " ######   #######  ##     ## ########     ###    ##    ## #### ########  ######                 ######  ######## ########  ##     ## ####  ######  ######## \r\n"
				+ "##    ## ##     ## ###   ### ##     ##   ## ##   ###   ##  ##  ##       ##    ##               ##    ## ##       ##     ## ##     ##  ##  ##    ## ##       \r\n"
				+ "##       ##     ## #### #### ##     ##  ##   ##  ####  ##  ##  ##       ##                     ##       ##       ##     ## ##     ##  ##  ##       ##       \r\n"
				+ "##       ##     ## ## ### ## ########  ##     ## ## ## ##  ##  ######    ######     #######     ######  ######   ########  ##     ##  ##  ##       ######   \r\n"
				+ "##       ##     ## ##     ## ##        ######### ##  ####  ##  ##             ##                     ## ##       ##   ##    ##   ##   ##  ##       ##       \r\n"
				+ "##    ## ##     ## ##     ## ##        ##     ## ##   ###  ##  ##       ##    ##               ##    ## ##       ##    ##    ## ##    ##  ##    ## ##       \r\n"
				+ " ######   #######  ##     ## ##        ##     ## ##    ## #### ########  ######                 ######  ######## ##     ##    ###    ####  ######  ######## ";

		System.out.println(str);
	}

	public static void customersServicecheck() {

		String str = " ######  ##     ##  ######  ########  #######  ##     ## ######## ########   ######                 ######  ######## ########  ##     ## ####  ######  ######## \r\n"
				+ "##    ## ##     ## ##    ##    ##    ##     ## ###   ### ##       ##     ## ##    ##               ##    ## ##       ##     ## ##     ##  ##  ##    ## ##       \r\n"
				+ "##       ##     ## ##          ##    ##     ## #### #### ##       ##     ## ##                     ##       ##       ##     ## ##     ##  ##  ##       ##       \r\n"
				+ "##       ##     ##  ######     ##    ##     ## ## ### ## ######   ########   ######     #######     ######  ######   ########  ##     ##  ##  ##       ######   \r\n"
				+ "##       ##     ##       ##    ##    ##     ## ##     ## ##       ##   ##         ##                     ## ##       ##   ##    ##   ##   ##  ##       ##       \r\n"
				+ "##    ## ##     ## ##    ##    ##    ##     ## ##     ## ##       ##    ##  ##    ##               ##    ## ##       ##    ##    ## ##    ##  ##    ## ##       \r\n"
				+ " ######   #######   ######     ##     #######  ##     ## ######## ##     ##  ######                 ######  ######## ##     ##    ###    ####  ######  ######## ";

		System.out.println(str);
	}

	public static void couponsServicecheck() {

		String str = " ######   #######  ##     ## ########   #######  ##    ##  ######                 ######  ######## ########  ##     ## ####  ######  ######## \r\n"
				+ "##    ## ##     ## ##     ## ##     ## ##     ## ###   ## ##    ##               ##    ## ##       ##     ## ##     ##  ##  ##    ## ##       \r\n"
				+ "##       ##     ## ##     ## ##     ## ##     ## ####  ## ##                     ##       ##       ##     ## ##     ##  ##  ##       ##       \r\n"
				+ "##       ##     ## ##     ## ########  ##     ## ## ## ##  ######     #######     ######  ######   ########  ##     ##  ##  ##       ######   \r\n"
				+ "##       ##     ## ##     ## ##        ##     ## ##  ####       ##                     ## ##       ##   ##    ##   ##   ##  ##       ##       \r\n"
				+ "##    ## ##     ## ##     ## ##        ##     ## ##   ### ##    ##               ##    ## ##       ##    ##    ## ##    ##  ##    ## ##       \r\n"
				+ " ######   #######   #######  ##         #######  ##    ##  ######                 ######  ######## ##     ##    ###    ####  ######  ######## ";
		System.out.println(str);

	}

	public static void adminFacadeCheck() {

		String str = "\r\n"
				+ "   ###    ########  ##     ## #### ##    ##         ########    ###     ######     ###    ########  ######## \r\n"
				+ "  ## ##   ##     ## ###   ###  ##  ###   ##         ##         ## ##   ##    ##   ## ##   ##     ## ##       \r\n"
				+ " ##   ##  ##     ## #### ####  ##  ####  ##         ##        ##   ##  ##        ##   ##  ##     ## ##       \r\n"
				+ "##     ## ##     ## ## ### ##  ##  ## ## ## ####### ######   ##     ## ##       ##     ## ##     ## ######   \r\n"
				+ "######### ##     ## ##     ##  ##  ##  ####         ##       ######### ##       ######### ##     ## ##       \r\n"
				+ "##     ## ##     ## ##     ##  ##  ##   ###         ##       ##     ## ##    ## ##     ## ##     ## ##       \r\n"
				+ "##     ## ########  ##     ## #### ##    ##         ##       ##     ##  ######  ##     ## ########  ######## ";

		System.out.println(str);
	}

	public static void companyFacadeCheck() {

		String str = " ######   #######  ##     ## ########     ###    ##    ## ##    ##         ########    ###     ######     ###    ########  ######## \r\n"
				+ "##    ## ##     ## ###   ### ##     ##   ## ##   ###   ##  ##  ##          ##         ## ##   ##    ##   ## ##   ##     ## ##       \r\n"
				+ "##       ##     ## #### #### ##     ##  ##   ##  ####  ##   ####           ##        ##   ##  ##        ##   ##  ##     ## ##       \r\n"
				+ "##       ##     ## ## ### ## ########  ##     ## ## ## ##    ##    ####### ######   ##     ## ##       ##     ## ##     ## ######   \r\n"
				+ "##       ##     ## ##     ## ##        ######### ##  ####    ##            ##       ######### ##       ######### ##     ## ##       \r\n"
				+ "##    ## ##     ## ##     ## ##        ##     ## ##   ###    ##            ##       ##     ## ##    ## ##     ## ##     ## ##       \r\n"
				+ " ######   #######  ##     ## ##        ##     ## ##    ##    ##            ##       ##     ##  ######  ##     ## ########  ######## ";

		System.out.println(str);
	}

	public static void customerFacadeCheck() {

		String str = " ######  ##     ##  ######  ########  #######  ##     ## ######## ########          ########    ###     ######     ###    ########  ######## \r\n"
				+ "##    ## ##     ## ##    ##    ##    ##     ## ###   ### ##       ##     ##         ##         ## ##   ##    ##   ## ##   ##     ## ##       \r\n"
				+ "##       ##     ## ##          ##    ##     ## #### #### ##       ##     ##         ##        ##   ##  ##        ##   ##  ##     ## ##       \r\n"
				+ "##       ##     ##  ######     ##    ##     ## ## ### ## ######   ########  ####### ######   ##     ## ##       ##     ## ##     ## ######   \r\n"
				+ "##       ##     ##       ##    ##    ##     ## ##     ## ##       ##   ##           ##       ######### ##       ######### ##     ## ##       \r\n"
				+ "##    ## ##     ## ##    ##    ##    ##     ## ##     ## ##       ##    ##          ##       ##     ## ##    ## ##     ## ##     ## ##       \r\n"
				+ " ######   #######   ######     ##     #######  ##     ## ######## ##     ##         ##       ##     ##  ######  ##     ## ########  ######## ";

		System.out.println(str);
	}

	public static void separatorLine() {
		System.out.println();
		System.out.println("===========================================================================");
		System.out.println();
		System.out.println();
	}

	public static void sepLine() {
		System.out.println("===========================================================================");
	}

	public static void printTestLine(String s) {
		System.out.println();
		System.out.println(String.format("----------------------%s----------------------", s));
		System.out.println();
	}

	public static void printCompaniesTable(List<Company> companies) {
		System.out.println();
		System.out.printf("%10s %10s %20s %10s %10s", "id", "name", "email", "password", "coupons");
		System.out.println();
		CheckTitle.sepLine();
		for (int i = 0; i < companies.size(); i++) {
			System.out.printf("%10s %10s %20s %10s %10s", (companies.get(i)).getId(), (companies.get(i)).getName(),
					(companies.get(i)).getEmail(), (companies.get(i)).getPassword(), (companies.get(i)).getCoupons());
			System.out.println();
		}

	}

	public static void printOneCompany(Company company) {
		System.out.println();
		if (company != null) {
			System.out.printf("%10s %10s %20s %10s %10s", "id", "name", "email", "password", "coupons");
			System.out.println();
			CheckTitle.sepLine();
			System.out.printf("%10s %10s %20s %10s %10s", (company.getId()), (company.getName()), (company.getEmail()),
					(company.getPassword()), (company.getCoupons()));
			System.out.println();
		}
	}

	public static void printCustomersTable(List<Customer> customers) {
		System.out.println();
		System.out.printf("%10s %10s %10s %20s %10s %10s", "id", "first", "last", "email", "password", "coupons");
		System.out.println();
		CheckTitle.sepLine();
		for (int i = 0; i < customers.size(); i++) {
			System.out.printf("%10s %10s %10s %20s %10s %10s", (customers.get(i)).getId(),
					(customers.get(i)).getFirstName(), (customers.get(i)).getLastName(), (customers.get(i)).getEmail(),
					(customers.get(i)).getPassword(), (customers.get(i)).getCoupons());
			System.out.println();
		}
	}

	public static void printOneCustomer(Optional<Customer> optional) {
		System.out.println();
		if (optional != null) {
			System.out.printf("%10s %10s %10s %20s %10s %10s", "id", "first", "last", "email", "password", "coupons");
			System.out.println();
			CheckTitle.sepLine();
			System.out.printf("%10s %10s %10s %20s %10s %10s", (optional).get().getId(), (optional).get().getFirstName(),
					(optional).get().getLastName(), (optional).get().getEmail(), (optional).get().getPassword(), (optional).get().getCoupons());
			System.out.println();
		}
	}

	public static void printCouponsTable(List<Coupon> coupons) {
		System.out.println();
		System.out.printf("%10s %10s %20s %10s %20s %10s %10s %10s %10s %10s", "id", "companyID", "category", "title",
				"description", "startDate", "endDate", "amount", "price", "img");
		System.out.println();
		System.out.print("===============================================================");
		CheckTitle.sepLine();
		for (int i = 0; i < coupons.size(); i++) {
			System.out.printf("%10s %10s %20s %10s %20s %10s %10s %10s %10s %10s", (coupons.get(i)).getId(),
					(coupons.get(i)).getCompanyID(), (coupons.get(i)).getCategory(), (coupons.get(i)).getTitle(),
					(coupons.get(i)).getDescription(), (coupons.get(i)).getStartDate(), (coupons.get(i)).getEndDate(),
					(coupons.get(i)).getAmount(), (coupons.get(i)).getPrice(), (coupons.get(i)).getImage());
			System.out.println();
		}
	}

	public static void printOneCoupon(Coupon coupon) {
		System.out.println();
		if (coupon != null) {
			System.out.printf("%10s %10s %20s %10s %20s %10s %10s %10s %10s %10s", "id", "companyID", "category",
					"title", "description", "startDate", "endDate", "amount", "price", "img");
			System.out.println();
			System.out.print("===============================================================");
			CheckTitle.sepLine();
			System.out.printf("%10s %10s %20s %10s %20s %10s %10s %10s %10s %10s", (coupon).getId(),
					(coupon).getCompanyID(), (coupon).getCategory(), (coupon).getTitle(), (coupon).getDescription(),
					(coupon).getStartDate(), (coupon).getEndDate(), (coupon).getAmount(), (coupon).getPrice(),
					(coupon).getImage());
			System.out.println();
		}
	}

}
