#ifndef EMPLOYEE_H
#define EMPLOYEE_H
#include<string>
using namespace std;
class Employee
{
private:
	string name;
	int empNum;
	string date;
public:
	class InvalidEmployeeNumber
	{};
	Employee() :Employee("", 0, "")
	{}
	Employee(string n, int num, string d)
	{
		name = n; empNum = num; date = d;
	}
	void setName(string);
	void setNum(int);
	void setDate(string);
	string getName() const
	{
		return name;
	}
	int getNum() const
	{
		return empNum;
	}
	string getDate() const
	{
		return date;
	}
};
#endif