;Ali Tayeh											Assignment5												CMSC-403


;Question 1
; creates a function named myList that return a cutsom list
( defun myList () (list 4 (list 7 22) "art" (list "math" (list 8) 99) 100))


;Question 2
; creates a function called leapYear that calculates the leap year from years 1800 - 2018, by creating a conditional
; that checks if the year is dividing by 100 and 4 but not 400 and if so then append it to a list of leapyears
(defun leapYear ()

		(defun recur(targetYear &optional leapList)
				(cond 
					(
						(> targetYear 2018) leapList
					)
					(	
						(and (= (mod targetYear 100) 0) (/= (mod targetYear 400) 0) (= (mod targetYear 4) 0))
				    	(recur (+ targetYear 4) leapList)
				    	
			    	)
			    	(
			    		1 (recur (+ targetYear 4) (append leapList (list targetYear)))
			    	)

    			)
			)(recur 1800 '())
	)



;Question 3
; a union function that returns a list if one of the lists is empty, if not then take the first element of 
; first list then recursively call the function with rest of first list as first parameter and a second list that's 
; made of adjoining the first element of the first list with the rest of elmenets from second list.

; P.S. fList=first list, slist= second list
(defun union- (fList sList) 
	(cond 
		(
			(= 0 (length fList))
			sList
		)

		(
			(union- (cdr fList) (adjoin (car fList) sList))
		)


	)


)


;Question 4
; checks if the list is empty and if so then return nil, otherwise use the else stmt that has progn which allows 
; the else stmt to execute multiple stmts in its body, in there, use a local-recursive function that takes in a 
; (list, listAddr(adds up our elements in list) and the list size), if list is empty then return listAddr/listSize, otherwise
; call our local recursive function that works on the rest of our list, adds more elements from our list to listAddr and 
; increments our list size.
(defun avg (aList)

  (cond 
    ( 
      (= 0 (length aList)) NIL
    )
    ( 
      1
      (progn

        (defun calcAvg (listSum listAddr listSize)
          (cond
            ( 
              (= 0 (length listSum)) (/ listAddr listSize)
            )
            ( 
              1 (calcAvg (cdr listSum) (+ listAddr (car listSum)) (+ listSize 1))
            )
          )
        )
		 (calcAvg aList 0 0)
      )
    )
  )
)



;Question 5
; An anonymous function is a function without a name and that's why lambda(symbol of anonymous function) is being used
; the keyword "function" initiates the anonymoys function call, typep is a type specifier that returns true if the passed
; in value is of the type specified by typep, otherwise it returns false
(defun isType (dataType) 
  (function (lambda (someType) (typep someType dataType )))
)


;Question 6
; a function that calculates tax based on limit, rate and the values
; uses mapcar because it applies to each element in the list in order or successively,
; if an item in our values is greater than the limit then multiply it by the rate, otherwise, return the elmement
(defun taxCalculator (limit rate values)
  

  (mapcar #'(lambda (element) 
                (cond 
                  ( (> element limit) (* element rate) ) ( 1 element )
                )
              )
        values
  ) 
)

;Question 7
; first thing the clean function does is check if the list is empty and if so return nil,
; otherwise, use funcall to call aFunc on our list and use nconc to return the concatenated list of our operation
; else, call the clean function on whats left of the list
(defun clean (aFunc aList)


  (cond
    ( 
      (= 0 (length aList)) NIL
    ) 
    ( 
      (funcall aFunc (car aList)) 
      (nconc (car aList) (clean aFunc (cdr aList))) 
    )
    ( 
      1 (clean aFunc (cdr aList))
    )
  )  
)



; Question 8
; uses labels to utilize binding that contains function name, arguments, and function body. 
; This type of Binding is perfect for recursive functions
;  checks if the stmntlist is empty, if so return nil
; else, check the first element of the list, then use the rest of the list
; lastly, a cond with 3 conditionals execute, if x >y then work on first sublist, if y<x work on second sublist,
; otherwise, work on the 3rd sublist
(defmacro threeWayBranch (x y toExecute)
  ;
  (labels
    (
      (
        customMacro 
        (stmtLists)
        (cond
          ( 
            (= 0 (length stmtLists)) NIL
          )

          ( 
            1 
            (progn
              (eval (car stmtLists)) 
              (customMacro (cdr stmtLists)) 
            )
          )
        )  
      )
    )
    (cond
      ((> x y) (customMacro (car (cdr toExecute) )))	
      ((< x y) (customMacro (car toExecute)))
      (1 (customMacro (car (cdr (cdr toExecute)))))
    )
  )
)




















