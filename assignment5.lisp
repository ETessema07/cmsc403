
( defun myList () (list 4 (list 7 22) "art" (list "math" (list 8) 99) 100)

	)

(defun leapYear ()

		(defun recur(a &optional li)
				(cond 
					(
						(> a 2018)
						li
					)
					(
				    	
						(and (= (mod a 100) 0) (/= (mod a 400) 0) (= (mod a 4) 0))
				    	(recur (+ a 4) li)
				    	
			    	)
			    	(
			    		T
			    		(recur (+ a 4) (append li (list a)))
			    	)

    			)

			)
		

		(recur 1800 '())
	)














