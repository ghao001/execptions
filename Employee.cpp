#include "stdafx.h"
#include<string>
#include"Employee.h"
using namespace std;

void Employee::setName(string s)
{
	name = s;
}
void Employee::setNum(int n)
{
	if (n < 0 || n>9999)
		throw InvalidEmployeeNumber();
	empNum = n;
}
void Employee::setDate(string s)
{
	date = s;
}