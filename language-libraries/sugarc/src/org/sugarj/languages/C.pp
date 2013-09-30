[
   AdditiveExpression -- H[H[_1 KW["+"]] _2],
   AdditiveExpression -- H[H[_1 KW["-"]] _2],
   AndExpression -- H[H[_1 KW["&"]] _2],
   AssignmentExpression -- H[_1 _2 _3],
   CastExpression -- H[H hs=0[KW["("] _1 KW[")"]] _2],
   CompoundStatement -- V[V is=2[KW["{"] _1] KW["}"]],
   ConditionalExpression -- H[H[_1 KW["?"] _2 KW[":"]] _3],
   Declaration -- H[_1 H hs=0[_2 KW[";"]]],
   Declarator -- H hs=0[_1],	%% -- H hs=0[p _1],
   DirectDeclarator -- H hs=0[KW["("] _1 KW[")"]],
   DirectDeclarator -- H hs=0[_1 H hs=0[KW["["] _2 _3 KW["]"]]],
   DirectDeclarator -- H hs=0[_1
                      H hs=0[KW["["]
                             KW["static"] _2 _3
                             KW["]"]]],
   DirectDeclarator -- H hs=0[_1
                      H hs=0[KW["["]
                             _2 KW["static"] _3
                             KW["]"]]],
   DirectDeclarator -- H hs=0[_1 H hs=0[KW["["] _2 KW["*"] KW["]"]]],
   DirectDeclarator -- H hs=0[_1 H hs=0[KW["("]
                                              _2
                                              KW[")"]]],
   DirectDeclarator -- H hs=0[_1 H hs=0[KW["("] _2 KW[")"]]],

   Pointer -- H hs=0[KW["*"] _1],
   EnumSpecifier -- V[H[KW["enum"] _1] V is=2[KW["{"] _2] KW["}"]],
   EnumSpecifier -- V[H[KW["enum"] _1] V is=2[KW["{"] _2] KW["}"]],
   EnumSpecifier -- V[H[KW["enum"] _1]],
   EnumeratorList -- H hs=0[_1 KW[","]], %% -- H[_1], _1=H hs=0[_2 KW[","]],      pp(H[enud], enud=H hs=0[EnumeratorDefinition KW[","]])
   EnumeratorDefinition -- H[_1 H[KW["="] _2]],
            
   EqualityExpression -- H[H[_1 KW["=="]] _2],
   EqualityExpression -- H[H[_1 KW["!="]] _2],
   ExclusiveOrExpression -- H[H[_1 KW["^"]] _2],
   Expression -- H hs=0[_1 KW[","]], %%-- H[_1], _1=H hs=0[_2 KW[","]],
   ExpressionStatement -- H hs=0[_1 KW[";"]],
   FunctionDefinition -- V[H[_1 H[_2 _3]] _4],
   Identifier -- VAR[_1],
   InclusiveOrExpression -- H[H[_1 KW["|"]] _2],
   InitDeclaratorList -- H hs=0[_1 KW[","]], %%-- H[_1], _1=H hs=0[_2 KW[","]],
   InitDeclarator -- H[_1 KW["="] _2],
   IterationStatement -- V is=2[H[KW["while"]
                        H hs=0[KW["("] _1 KW[")"]]] _2],
   IterationStatement -- V[V is=2[KW["do"] _1]
                 H[KW["while"] H hs=0[KW["("] _2 KW[")"] KW[";"]]]],
   IterationStatement -- V is=2[H[KW["for"]
                        H hs=0[KW["("] H[H hs=0[H[_1] KW[";"]]
                                         H hs=0[H[_2] KW[";"]] _3] KW[")"]]]
                      _4],
   IterationStatement -- V is=2[H[KW["for"] H hs=0[KW["("]
                                         H[_1
                                           H hs=0[_2 KW[";"]] _3] KW[")"]]]
                      _3],
                      
   JumpStatement -- H hs=0[KW["break"] KW[";"]],
   JumpStatement -- H hs=0[KW["continue"] KW[";"]],
   JumpStatement -- H[KW["return"] H hs=0[_1 KW[";"]]],
   JumpStatement -- H[KW["goto"] H hs=0[_1 KW[";"]]],
   LabeledStatement -- V[H hs=0[_1 KW[":"]] _2],
   LabeledStatement -- V is=2[H[KW["case"]
                      H hs=0[_1 KW[":"]]] _2],
   LabeledStatement -- V is=2[H hs=0[KW["default"] KW[":"]] _1],
   LogicalAndExpression -- H[H[_1 KW["&&"]] _2],
   LogicalOrExpression -- H[H[_1 KW["||"]] _2],
   MultiplicativeExpression -- H[H[_1 KW["*"]] _2],
   MultiplicativeExpression -- H[H[_1 KW["/"]] _2],
   MultiplicativeExpression -- H[H[_1 KW["%"]] _2],
   ParameterTypeList -- H[H hs=0[_1 KW[","]] KW["..."]],
   ParameterList -- H hs=0[_1 KW[","]], %% -- H[pd], pd=H hs=0[_1 KW[","]],
   ParameterDeclaration -- H[_1 _2],
   ParameterDeclaration -- H[_1 _2],
   PostfixExpression -- H hs=0[_1 H hs=0[KW["["] _2 KW["]"]]],
   PostfixExpression -- H hs=0[_1 H hs=0[KW["("] _2 KW[")"]]],
   PostfixExpression -- H hs=0[H hs=0[_1 KW["."]] _2],
   PostfixExpression -- H hs=0[H hs=0[_1 KW["->"]] _2],
   PostfixExpression -- H hs=0[_1 KW["++"]],
   PostfixExpression -- H hs=0[_1 KW["--"]],
   PrimaryExpression -- H hs=0[KW["("] _1 KW[")"]],
   RelationalExpression -- H[H[_1 KW["<"]] _2],
   RelationalExpression -- H[H[_1 KW[">"]] _2],
   RelationalExpression -- H[H[_1 KW["<="]] _2],
   RelationalExpression -- H[H[_1 KW[">="]] _2],
   SelectionStatement -- V is=2[H[KW["if"] H hs=0[KW["("] _1 KW[")"]]] _2],
   SelectionStatement -- V[V is=2[H[KW["if"] H hs=0[KW["("] _1 KW[")"]]] _2]
                 V is=2[KW["else"] _3]],
   SelectionStatement -- V is=2[H[KW["switch"] H hs=0[KW["("] _1 KW[")"]]]
                      _2],
   ShiftExpression -- H[H[_1 KW["<<"]] _2],
   ShiftExpression -- H[H[_1 KW[">>"]] _2],
   DeclarationSpecifierSeq -- H[_1],
   StructOrUnionSpecifier -- V[H[_1 _2]
            V is=2[KW["{"]
              H[_1]]
              KW["}"]],

   StructDeclarationList -- V vs=1[_1],  %% -- V[_1], _1=V vs=1[_2],

   StructDeclaration -- H[_1 H hs=0[_2 KW[";"]]],

   StructDeclaratorList -- H hs=0[_1 KW[","]],  %% -- H[_1], _1=H hs=0[_2 KW[","]],
   ExternalDeclarationSeq -- V vs=1[_1], %%-- V[_1], _1=V vs=1[_2],
   DirectAbstractDeclarator -- H hs=0[KW["("] _1 KW[")"]],
   DirectAbstractDeclarator -- H hs=0[_1 H hs=0[KW["["] _2 KW["]"]]],
   DirectAbstractDeclarator -- H hs=0[_1 H hs=0[KW["["] KW["*"] KW["]"]]],
   DirectAbstractDeclarator -- H hs=0[_1 KW["("] _2 KW[")"]],
   UnaryExpression -- H hs=0[KW["++"] _1],
   UnaryExpression -- H hs=0[KW["--"] _1],
   UnaryExpression -- H hs=0[_1 _2],
   UnaryExpression -- H[KW["sizeof"] _1],
   UnaryExpression -- H[KW["sizeof"] H hs=0[KW["("] H[_1] KW[")"]]]
]
