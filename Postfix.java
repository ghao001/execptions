public class Postfix
{
    public static String convertToPostfix(String infix)
    {
        StackInterface<Character> operatorStack = new LinkedStack<>();

        // use a StringBuilder object rather than a String, since appending is much more efficient.
        // To add to the StringBuilder object 'postfix':
        // postfix.append(stringToAppend);
        StringBuilder postfix = new StringBuilder();
        int length = infix.length();
        for(int i = 0; i < length; i++)
        {
            char nextCharacter = infix.charAt(i);
            if(isVariable(nextCharacter))
            {
                postfix.append(nextCharacter);
            }
            else
            {
                if(isOperator(nextCharacter))
                {
                    if(getPrecedence(nextCharacter)>getPrecedence(operatorStack.peek()))
                    {
                        operatorStack.push(nextCharacter);
                    }
                    else
                    {
                        while(getPrecedence(nextCharacter)<=getPrecedence(operatorStack.peek())
                              &&!operatorStack.isEmpty())
                        {
                            postfix.append(operatorStack.pop());
                        }
                        operatorStack.push(nextCharacter);
                    }
                }
                else switch(nextCharacter)
                {
                    case '(':
                      operatorStack.push('(');
                      break;
                    case ')':
                      while(nextCharacter!=')')
                      {
                          postfix.append(operatorStack.pop());
                      }
                }
                
            }
        }
        while(!operatorStack.isEmpty())
        {
            postfix.append(operatorStack.pop());
        }

        return postfix.toString();
    }

    public static int evaluatePostfix(String postfix)
    {
        StackInterface<Integer> varStack=new LinkedStack<>();
        int s,t,result;
        Integer x;
        for(int i=0;i<postfix.length();i++)
        {
            char ch=postfix.charAt(i);
            if(isVariable(ch))
            {
                x=getValue(ch);
                varStack.push(x);
            }
            else if(isOperator(ch))
            {
                t=varStack.pop();
                s=varStack.pop();
                varStack.push(performOperation(t,s,ch));
            }
        }
        result=varStack.peek;
        return result;
    }

    private static int getValue(char c)
    {
        switch(c)
        {
            case 'a':
                return 2;
            case 'b':
                return 3;
            case 'c':
                return 4;
            case 'd':
                return 5;
            case 'e':
                return 6;
            default:
                return 0;
        }
    }


    private static int performOperation(int operandOne, int operandTwo, char operator)
    {
        switch(operator)
        {
            case '+': return operandOne+operandTwo;
            case '-': return operandOne-operandTwo;
            case '*': return operandOne*operandTwo;
            case '/': return operandOne/operandTwo;
        }
    }

    private static int getPrecedence(char operator)
    {
        switch (operator)
        {
            case '(': case ')': return 0;
            case '+': case '-': return 1;
            case '*': case '/': return 2;
            case '^':           return 3;
        }
        return -1;
    }

    private static boolean isOperator(char c)
    {
        return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^');
    }

    private static boolean isVariable(Character c)
    {
        return Character.isLetter(c);
    }
}