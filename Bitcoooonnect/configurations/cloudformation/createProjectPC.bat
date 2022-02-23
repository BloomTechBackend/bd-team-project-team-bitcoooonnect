aws cloudformation delete-stack --region us-east-2 --stack-name cryptoservice-createtables

timeout /t 60

aws cloudformation create-stack --region us-east-2 --stack-name cryptoservice-createtables --template-body file://tables.template.yml --capabilities CAPABILITY_IAM

timeout /t 10

aws dynamodb batch-write-item --region us-east-2 --request-items file://user1.json
