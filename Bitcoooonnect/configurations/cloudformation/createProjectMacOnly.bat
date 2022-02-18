aws cloudformation delete-stack --region us-east-2 --stack-name cryptoservice-createtables

sleep 60

aws cloudformation create-stack --region us-east-2 --stack-name cryptoservice-createtables --template-body file://tables.template.yml --capabilities CAPABILITY_IAM

sleep 10

aws dynamodb batch-write-item --region us-east-2 --request-items file://user1.json
aws dynamodb batch-write-item --region us-east-2 --request-items file://coin1.json
aws dynamodb batch-write-item --region us-east-2 --request-items file://coin2.json
aws dynamodb batch-write-item --region us-east-2 --request-items file://coin3.json
aws dynamodb batch-write-item --region us-east-2 --request-items file://coin4.json
aws dynamodb batch-write-item --region us-east-2 --request-items file://coin5.json
aws dynamodb batch-write-item --region us-east-2 --request-items file://coin6.json
aws dynamodb batch-write-item --region us-east-2 --request-items file://coin7.json
aws dynamodb batch-write-item --region us-east-2 --request-items file://coin8.json
aws dynamodb batch-write-item --region us-east-2 --request-items file://coin9.json
aws dynamodb batch-write-item --region us-east-2 --request-items file://coin10.json